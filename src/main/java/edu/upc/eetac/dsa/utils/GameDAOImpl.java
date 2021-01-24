package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.Inventory;
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
            i = null;
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return i;
    }

    @Override
    public void updateGame(String ID,String idObjects, String idAchievements, String idMap)
    {
        Game game= this.getGame(ID);
        game.setIdObjects(idObjects);
        game.setIdAchievements(idObjects);
        game.setIdMap(idMap);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(game);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteGame(String gameID) {
        Game game= this.getGame(gameID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Game.class);
        }
        catch (Exception e) {
        }
        finally {
            session.close();
        }
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
