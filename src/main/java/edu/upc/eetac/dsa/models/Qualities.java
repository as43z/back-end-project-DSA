package edu.upc.eetac.dsa.models;

public class Qualities {
    private String id;
    private int healthVal;
    private int calcVal;
    private int stamVal;
    private int logicVal;
    private int memVal;

    public Qualities(String id, int healthVal, int calcVal, int stamVal, int logicVal, int memVal) {
        this.id = id;
        this.healthVal = healthVal;
        this.calcVal = calcVal;
        this.stamVal = stamVal;
        this.logicVal = logicVal;
        this.memVal = memVal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealthVal() {
        return healthVal;
    }

    public void setHealthVal(int healthVal) {
        this.healthVal = healthVal;
    }

    public int getCalcVal() {
        return calcVal;
    }

    public void setCalcVal(int calcVal) {
        this.calcVal = calcVal;
    }

    public int getStamVal() {
        return stamVal;
    }

    public void setStamVal(int stamVal) {
        this.stamVal = stamVal;
    }

    public int getLogicVal() {
        return logicVal;
    }

    public void setLogicVal(int logicVal) {
        this.logicVal = logicVal;
    }

    public int getMemVal() {
        return memVal;
    }

    public void setMemVal(int memVal) {
        this.memVal = memVal;
    }
}
