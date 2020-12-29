package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

public class Item {
    private String ID;
    private String name;
    private String description;

    public Item(){
        this.ID = RandomUtils.getRandID();
    }

    public Item(String name, String description){
        this();
        this.name = name;
        this.description = description;
    }

    public Item(String ID, String name, String description){
        this.ID = ID;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
