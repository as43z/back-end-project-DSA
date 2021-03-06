package edu.upc.eetac.dsa.models;

public class Maps {

    private String ID;
    private String name;
    private String vectMap;

    public Maps() {
    }

    public Maps(String ID, String name, String vectMap) {
        this.ID = ID;
        this.name = name;
        this.vectMap = vectMap;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
