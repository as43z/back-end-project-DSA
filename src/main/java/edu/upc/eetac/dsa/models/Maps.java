package edu.upc.eetac.dsa.models;

public class Maps {
    private String id;
    private String name;
    private String vectMap;

    public Maps(String id, String name, String vectMap) {
        this.id = id;
        this.name = name;
        this.vectMap = vectMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVectMap() {
        return vectMap;
    }

    public void setVectMap(String vectMap) {
        this.vectMap = vectMap;
    }
}
