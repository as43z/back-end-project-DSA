package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.utils.ObjectHelper;
import edu.upc.eetac.dsa.utils.QueryHelper;

import java.sql.*;
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
        String iQuery = QueryHelper.queryInsert(entity); //INSERT QUERY
        PreparedStatement pstm = null; //NULL

        try {
            pstm = conn.prepareStatement(iQuery); //EMPEZAMOS A PREPARARLO
            int i = 1;
            for(String field : ObjectHelper.getFields(entity)){
                Object o = ObjectHelper.getter(entity, field); //Cada Objecto -> devuelve el valor del campo
                pstm.setObject(i, o); //BUILD
                i++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        Object o = null;
        PreparedStatement pstm = null;
        try{
            String sQuery =  QueryHelper.querySelect(c);

            o = c.newInstance();
            pstm = conn.prepareStatement(sQuery);
            pstm.setObject(1, ID);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                ResultSetMetaData rsMeta = rs.getMetaData();
                for(int i = 1; i < rsMeta.getColumnCount(); i++){
                    String prop = rsMeta.getColumnClassName(i);
                    ObjectHelper.setter(o, prop, rs.getObject(i));
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return o;
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
