package edu.upc.eetac.dsa;
/*
*   +--------------+
*   |   IMPORTS    |
*   +--------------+
 */
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import org.glassfish.jersey.server.ResourceConfig;

import java.net.InetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;

public class Main {
    //                      vars
    //------------------------------------------------------
    // Logger
    static final Logger log = Logger.getLogger(Main.class);

    // Base para los directorios
    static final String PACKAGE_PATH = "edu.upc.eetac.dsa.";

    // Base de la API
    static final String BASE_PATH = "dsaApp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer(String ipAddr, String BASE_URI) {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.dsa package
        final ResourceConfig rc = new ResourceConfig().packages(PACKAGE_PATH + "service");

        rc.register(io.swagger.jaxrs.listing.ApiListingResource.class);
        rc.register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setHost(ipAddr + ":8080");
        beanConfig.setBasePath(BASE_PATH);
        beanConfig.setContact("albert.saez.nunez@estudiantat.upc.edu / victor.moreno.barrera@estudiantat.upc.edu / renuka.jain@estudiantat.upc.edu / marc.xapelli@estudiantat.upc.edu / javier.salmeron@estudiantat.upc.edu / guillem.montejo@estudiantat.upc.edu .");
        beanConfig.setDescription("API for game project");
        beanConfig.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
        beanConfig.setResourcePackage(PACKAGE_PATH + "service");
        beanConfig.setTermsOfServiceUrl("http://www.example.com/resources/eula");
        beanConfig.setTitle("REST API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setScan(true);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args - Argument
     * @throws IOException -Throws IOException
     */
    public static void main(String[] args) throws IOException {
        // config IP, si la IP contiene 147.83.X.X, cambiala, si no, localhost
        InetAddress machineIP = InetAddress.getLocalHost();
        String ipAddr = "localhost";
        if(machineIP.getHostAddress().contains("147.83.")) ipAddr = machineIP.getHostAddress();

        // El server estará aquí:
        final String BASE_URI = "http://"+ ipAddr +":8080/" + BASE_PATH;

        // Swagger
        final String SWAGGER_URI = BASE_URI.replace(BASE_PATH, "swagger/");

        // configurar el logger
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        log.info("Server will be running at interface @IP: " + ipAddr);
        log.info("init sys");

        // arrancar el server
        final HttpServer server = startServer(ipAddr, BASE_URI);

        // base
        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");

        // info
        log.info("Greeting page @ http://" + ipAddr + ":8080/");
        log.info("API started @ " + BASE_URI);
        log.info("SWAGGER service @ " + SWAGGER_URI);

        // apagar el server
        System.out.println("ENTER to stop...");
        System.in.read();
        server.shutdownNow();
    }

}
