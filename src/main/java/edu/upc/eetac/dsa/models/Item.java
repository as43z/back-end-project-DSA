package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

public class Item {
    private String ID;
    private String name;
    private String description;
    private int price;
    private String image;


    public Item(){
        this.ID = RandomUtils.getRandID();
    }

    public Item(String name, String description){
        this();
        this.name = name;
        this.description = description;
    }

    public Item(String ID, String name, String description, int price, String image){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
