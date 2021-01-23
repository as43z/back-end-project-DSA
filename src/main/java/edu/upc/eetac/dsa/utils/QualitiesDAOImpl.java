package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.Qualities;

import java.util.List;

public class QualitiesDAOImpl implements QualitiesDAO {
    @Override
    public Qualities addQualities(Qualities qualities) {
        Session session =  null;

        try
        {
            session = FactorySession.openSession();
            session.save(qualities);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return qualities;
    }

    @Override
    public Qualities getQualities(String qualitiesID) {
        Session session = null;
        Qualities i = null;
        try {
            session = FactorySession.openSession();
            i = (Qualities) session.get(Qualities.class, qualitiesID);

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
    public Qualities updateQualities(Qualities qualities) {
        Session session =  null;

        try{
            session = FactorySession.openSession();
            session.save(qualities);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return qualities;
    }

    @Override
    public void deleteQualities(String gameID) {

    }

    @Override
    public List<Qualities> getQualitiesList() {

        Session session = null;
        List<Qualities> lQualities = null;
        try{
            session = FactorySession.openSession();
            lQualities = session.findAll(Qualities.class);

        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lQualities;
    }
}
