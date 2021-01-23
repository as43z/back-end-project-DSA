package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Game;

import java.util.List;

public interface GameDAO {
    Game addGame(Game game);
    Game getGame(String gameID);
    void updateGame(String ID, String idQualities, String idObjects, String idAchievements, String idMap);
    void deleteGame(String gameID);
    List<Game> getGames();
}
