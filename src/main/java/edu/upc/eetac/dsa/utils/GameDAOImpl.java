package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.Item;

import java.util.List;

public class GameDAOImpl implements GameDAO {
    @Override
    public Game addGame(Game game) {

        Session session =  null;

        try{
            session = FactorySession.openSession();
            session.save(game);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return game;
    }

    @Override
    public Game getGame(String gameID) {

        Session session = null;
        Game i = null;
        try {
            session = FactorySession.openSession();
            i = (Game) session.get(Game.class, gameID);

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
    public void updateGame(String ID, String idQualities, String idObjects, String idAchievements, String idMap) {

    }

    @Override
    public void deleteGame(String gameID) {

    }

    @Override
    public List<Game> getGames() {
        Session session = null;
        List<Game> lGames = null;
        try{
            session = FactorySession.openSession();
            lGames = session.findAll(Game.class);

        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lGames;
    }
}
