package edu.upc.eetac.dsa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SessionImpl implements Session {
    private Connection conn;

    public SessionImpl(Connection conn) {
        //START A CONNECTION
        this.conn = conn;
    }

    @Override
    public void save(Object entity) {
        //SAVE AN OBJECT TO THE DATABASE (Crud)
    }

    @Override
    public void close() {
        //CLOSE CONNECTION
        try{
            this.conn.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Object get(Class c, String ID) {
        //READ AN OBJECT FROM THE DATABASE (cRud)
        return null;
    }

    /*
    TODO:
        - Update method
        - Delete method
        - Get all method
    */
    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public List<Object> findAll(Class c) {
        return null;
    }
}
