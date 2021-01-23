package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Achievements;
import edu.upc.eetac.dsa.models.QualityDescription;

import java.util.List;

public class QualityDescriptionDAOImpl implements QualityDescriptionDAO {
    @Override
    public QualityDescription addQualityDescription(QualityDescription qualityDescription) {
        Session session =  null;

        try{
            session = FactorySession.openSession();
            session.save(qualityDescription);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return qualityDescription;
    }

    @Override
    public QualityDescription getQualityDescription(String qualityDescriptionID) {
        Session session = null;
        QualityDescription i = null;
        try {
            session = FactorySession.openSession();
            i = (QualityDescription) session.get(QualityDescription.class, qualityDescriptionID);

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
    public void updateQualityDescription(String ID, String name, String description) {

    }

    @Override
    public void deleteQualityDescription(String qualityDescriptionID) {

    }

    @Override
    public List<QualityDescription> getQualityDescriptions() {
        Session session = null;
        List<QualityDescription> lQualityDescription = null;
        try{
            session = FactorySession.openSession();
            lQualityDescription = session.findAll(QualityDescription.class);

        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lQualityDescription;
    }
}
