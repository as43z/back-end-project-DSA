package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Achievements;
import edu.upc.eetac.dsa.models.Maps;

import java.util.List;

public class MapsDAOImpl implements MapsDAO{
    @Override
    public Maps addMaps(Maps maps) {
        Session session =  null;

        try{
            session = FactorySession.openSession();
            session.save(maps);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return maps;
    }

    @Override
    public Maps getMaps(String mapsID) {
        Session session = null;
        Maps i = null;
        try {
            session = FactorySession.openSession();
            i = (Maps) session.get(Maps.class, mapsID);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return i;
    }

    @Override
    public void updateMaps(String ID, String name, String vectMap) {

    }

    @Override
    public void deleteMaps(String mapsID) {

    }

    @Override
    public List<Maps> getMapsList() {
        Session session = null;
        List<Maps> lMaps = null;
        try{
            session = FactorySession.openSession();
            lMaps = session.findAll(Maps.class);

        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lMaps;
    }
}
