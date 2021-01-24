package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Achievements;
import edu.upc.eetac.dsa.models.Item;
import edu.upc.eetac.dsa.models.Maps;
import edu.upc.eetac.dsa.models.User;

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

        Maps map= this.getMaps(ID);
        map.setName(name);
        map.setVectMap(vectMap);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(Maps.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteMaps(String mapsID) {
        Maps map= this.getMaps(mapsID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Maps.class);
        }
        catch (Exception e) {
        }
        finally {
            session.close();
        }
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
