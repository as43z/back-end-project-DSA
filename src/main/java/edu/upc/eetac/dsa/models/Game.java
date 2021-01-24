package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

public class Game {
    private String ID;
    private String idObjects;
    private String idAchievements;

    public Game(String idObjects, String idAchievements) {
        this.ID = RandomUtils.getRandID();
        this.idObjects = idObjects;
        this.idAchievements = idAchievements;
    }

    public Game(String ID, String idObjects, String idAchievements) {
        this.ID = ID;
        this.idObjects = idObjects;
        this.idAchievements = idAchievements;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIdObjects() {
        return idObjects;
    }

    public void setIdObjects(String idObjects) {
        this.idObjects = idObjects;
    }

    public String getIdAchievements() {
        return idAchievements;
    }

    public void setIdAchievements(String idAchievements) {
        this.idAchievements = idAchievements;
    }
}
