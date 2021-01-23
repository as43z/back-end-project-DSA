package edu.upc.eetac.dsa.models;

public class QualityDescription {
    private String ID;
    private String name;
    private String description;

    public QualityDescription(String ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {
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
