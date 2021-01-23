package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Achievements;
import edu.upc.eetac.dsa.models.Game;

import java.util.List;

public class AchievementsDAOImpl implements  AchievementsDAO{
    @Override
    public Achievements addAchievements(Achievements achievements) {
        Session session =  null;

        try{
            session = FactorySession.openSession();
            session.save(achievements);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return achievements;
    }

    @Override
    public Achievements getAchievements(String achievementsID) {
        Session session = null;
        Achievements i = null;
        try {
            session = FactorySession.openSession();
            i = (Achievements) session.get(Achievements.class, achievementsID);

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
    public void updateAchievements(String ID, int calcAch, int electronicsAch, int commsAch, int oescAch, int dsaAch, int aeroAch, int tfgAch) {

    }

    @Override
    public void deleteAchievements(String achievementsID) {

    }

    @Override
    public List<Achievements> getAchievementsList() {

        Session session = null;
        List<Achievements> lAchievements = null;
        try{
            session = FactorySession.openSession();
            lAchievements = session.findAll(Achievements.class);

        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lAchievements;
    }
}
