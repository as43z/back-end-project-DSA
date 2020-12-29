package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.utils.ObjectHelper;
import edu.upc.eetac.dsa.utils.QueryHelper;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class SessionImpl implements Session {
    private Connection conn;
    private static final Logger log = Logger.getLogger(FactorySession.class);

    public SessionImpl(Connection conn) {
        //START A CONNECTION
        this.conn = conn;
    }

    @Override
    public void save(Object entity) {
        //SAVE AN OBJECT TO THE DATABASE (Crud)
        String iQuery = QueryHelper.queryInsert(entity); //INSERT QUERY
        PreparedStatement pstm = null; //NULL
        log.info("Saving object, QUERY " + iQuery);

        try {
            pstm = conn.prepareStatement(iQuery); //EMPEZAMOS A PREPARARLO
            int i = 1;
            for(String field : ObjectHelper.getFields(entity)){
                Object o = ObjectHelper.getter(entity, field); //Cada Objecto -> devuelve el valor del campo
                log.info("adding field at " + entity.getClass().getSimpleName() + " value " + String.valueOf(o));
                pstm.setObject(i, o); //BUILD
                i++;
            }
            pstm.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
            log.info("BAD PSTM");
        }
    }

    @Override
    public void close() {
        //CLOSE CONNECTION
        try{
            this.conn.close();
            log.info("Connection closed.");
        } catch(SQLException ex) {
            log.info("Something BAD happened.");
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
                for(int i = 1; i < rsMeta.getColumnCount() + 1; i++){
                    String prop = rsMeta.getColumnName(i);
                    ObjectHelper.setter(o, prop, rs.getObject(i));
                    log.info("Object " + o.getClass().getSimpleName() + " for var " + prop);
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
        String sQuery = QueryHelper.querySelectAll(c);
        List<Object> oList = new LinkedList<>();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sQuery);
            ResultSet rs = pstm.executeQuery(); // <- TABLA (0) 1 2 3 4 ... N (N + 1)

            while(rs.next()){ //<- si hay un siguiente, pasa el indice, y devuelve true o false segun si se ha podido.
                ResultSetMetaData rsMeta = rs.getMetaData();
                Object o = c.newInstance();
                for(int i = 1; i < rsMeta.getColumnCount() + 1; i++) {
                    String prop = rsMeta.getColumnName(i);
                    ObjectHelper.setter(o, prop, rs.getObject(i));
                    log.info(prop + ": " + rs.getObject(i));
                }
                oList.add(o);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return oList;
    }
}
