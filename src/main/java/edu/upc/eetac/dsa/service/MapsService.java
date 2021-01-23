package edu.upc.eetac.dsa.service;
import edu.upc.eetac.dsa.ManagerImpl;
import edu.upc.eetac.dsa.models.*;
import edu.upc.eetac.dsa.Manager;
import edu.upc.eetac.dsa.Manager;
import edu.upc.eetac.dsa.ManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//Models or Element Entity
//Swagger Imports
@Api(value = "/Maps", description = "Endpoint to Maps Service")
@Path("/Maps")
public class MapsService
{
    static final Logger logger = Logger.getLogger(MapsService.class);
    private Manager manager;

    public MapsService()
    {
        //Configuring Log4j, location of the log4j.properties file and must always be inside the src folder
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.manager = ManagerImpl.getInstance();

        if (this.manager.getMaps().size() == 0)
        {
            //Adding Maps
            this.manager.registerMap("1","Resa", "test");
            this.manager.registerMap("2","Cafeteria", "test");
            this.manager.registerMap("3","Campus", "test");
            this.manager.registerMap("4","Lago", "test");
            this.manager.registerMap("5","Clases", "test");
            this.manager.registerMap("6","Salon de actos", "test");
        }
    }

    //
    @GET
    @ApiOperation(value="Get all Maps", notes="get all maps")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Maps.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMaps(){
        List<Maps> maps = this.manager.getMaps();
        GenericEntity<List<Maps>> entity = new GenericEntity<List<Maps>>(maps){};
        return Response.status(201).entity(entity).header("Access-Control-Allow-Origin", "*").build();
    }

    //
    @GET
    @ApiOperation(value="get a map", notes="get a map")
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Successful", response = Maps.class, responseContainer = "List"),
    })
    @Path("/{mapID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap(@PathParam("mapID") String MapID){
        Maps entity = this.manager.getMap(MapID);
        return Response.status(201).entity(entity).build();
    }
}

