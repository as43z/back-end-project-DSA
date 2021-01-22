package edu.upc.eetac.dsa.models;

public class Game {
    private String id;
    private String idQualities;
    private String idObjects;
    private String idAchievements;
    private String idMap;

    public Game(String id, String idQualities, String idObjects, String idAchievements, String idMap) {
        this.id = id;
        this.idQualities = idQualities;
        this.idObjects = idObjects;
        this.idAchievements = idAchievements;
        this.idMap = idMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdQualities() {
        return idQualities;
    }

    public void setIdQualities(String idQualities) {
        this.idQualities = idQualities;
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
