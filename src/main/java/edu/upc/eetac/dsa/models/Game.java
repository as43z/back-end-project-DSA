package edu.upc.eetac.dsa.models;

public class Game {
    private String ID;
    private String idObjects;
    private String idAchievements;
    private String idMap;

    public Game(String ID, String idObjects, String idAchievements, String idMap) {
        this.ID = ID;
        this.idObjects = idObjects;
        this.idAchievements = idAchievements;
        this.idMap = idMap;
    }

    public String getId() {
        return ID;
    }

    public void setId(String ID) {
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

    public String getIdMap() {
        return idMap;
    }

    public void setIdMap(String idMap) {
        this.idMap = idMap;
    }
}
