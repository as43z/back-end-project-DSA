package edu.upc.eetac.dsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class FactorySession {
    private static final Logger log = Logger.getLogger(FactorySession.class);

    public static Session openSession()
    {
        Connection conn = getConnection();
        Session session = new SessionImpl(conn);
        log.info("opening session.");
        return session;
    }

    private static Connection getConnection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bbdd",
                            "root", "Mazinger72");
            log.info("connected to mariadebe");
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
}
