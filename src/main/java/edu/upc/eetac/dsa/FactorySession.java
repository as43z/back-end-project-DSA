package edu.upc.eetac.dsa;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class FactorySession {
    private static final Logger log = Logger.getLogger(FactorySession.class);

    public static Session openSession() throws UnknownHostException {
        Connection conn = getConnection();
        Session session = new SessionImpl(conn);
        log.info("opening session.");
        return session;
    }

    private static Connection getConnection() throws UnknownHostException {
        InetAddress machineIP = InetAddress.getLocalHost();
        String paswrd = "root";
        if(machineIP.getHostAddress().contains("147.83.")) paswrd = "Mazinger72";
        Connection conn = null;
        log.info("Connecting to Mariadb");
        try
        {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bbdd",
                            "root", paswrd);
            log.info("OK. Connection as ROOT.");
        }
        catch (SQLException ex) {
            // handle any errors
            log.info("Could not connect to MariaDB.");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
