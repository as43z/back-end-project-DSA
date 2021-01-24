package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

public class Inventory {
    private String ID;
    private int turtleQuantity;
    private int coffQuantity;
    private int redbullQuantity;
    private int pillsQuantity;
    private int calculatorQuantity;
    private int ruleQuantity;
    private int compassQuantity;
    private int pencilQuantity;
    private int glassesQuantity;
    private int puzzleQuantity;
    private int bookQuantity;
    private int usbQuantity;
    private int cheatQuantity;

    public Inventory(int turtleQuantity, int coffQuantity, int redbullQuantity, int pillsQuantity, int calculatorQuantity, int ruleQuantity, int compassQuantity, int pencilQuantity, int glassesQuantity, int puzzleQuantity, int bookQuantity, int usbQuantity, int cheatQuantity) {
        this.ID = RandomUtils.getRandID();
        this.turtleQuantity = turtleQuantity;
        this.coffQuantity = coffQuantity;
        this.redbullQuantity = redbullQuantity;
        this.pillsQuantity = pillsQuantity;
        this.calculatorQuantity = calculatorQuantity;
        this.ruleQuantity = ruleQuantity;
        this.compassQuantity = compassQuantity;
        this.pencilQuantity = pencilQuantity;
        this.glassesQuantity = glassesQuantity;
        this.puzzleQuantity = puzzleQuantity;
        this.bookQuantity = bookQuantity;
        this.usbQuantity = usbQuantity;
        this.cheatQuantity = cheatQuantity;
    }

    public Inventory(String ID, int turtleQuantity, int coffQuantity, int redbullQuantity, int pillsQuantity, int calculatorQuantity, int ruleQuantity, int compassQuantity, int pencilQuantity, int glassesQuantity, int puzzleQuantity, int bookQuantity, int usbQuantity, int cheatQuantity) {
        this.ID = ID;
        this.turtleQuantity = turtleQuantity;
        this.coffQuantity = coffQuantity;
        this.redbullQuantity = redbullQuantity;
        this.pillsQuantity = pillsQuantity;
        this.calculatorQuantity = calculatorQuantity;
        this.ruleQuantity = ruleQuantity;
        this.compassQuantity = compassQuantity;
        this.pencilQuantity = pencilQuantity;
        this.glassesQuantity = glassesQuantity;
        this.puzzleQuantity = puzzleQuantity;
        this.bookQuantity = bookQuantity;
        this.usbQuantity = usbQuantity;
        this.cheatQuantity = cheatQuantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getTurtleQuantity() {
        return turtleQuantity;
    }

    public void setTurtleQuantity(int turtleQuantity) {
        this.turtleQuantity = turtleQuantity;
    }

    public int getCoffQuantity() {
        return coffQuantity;
    }

    public void setCoffQuantity(int coffQuantity) {
        this.coffQuantity = coffQuantity;
    }

    public int getRedbullQuantity() {
        return redbullQuantity;
    }

    public void setRedbullQuantity(int redbullQuantity) {
        this.redbullQuantity = redbullQuantity;
    }

    public int getPillsQuantity() {
        return pillsQuantity;
    }

    public void setPillsQuantity(int pillsQuantity) {
        this.pillsQuantity = pillsQuantity;
    }

    public int getCalculatorQuantity() {
        return calculatorQuantity;
    }

    public void setCalculatorQuantity(int calculatorQuantity) {
        this.calculatorQuantity = calculatorQuantity;
    }

    public int getRuleQuantity() {
        return ruleQuantity;
    }

    public void setRuleQuantity(int ruleQuantity) {
        this.ruleQuantity = ruleQuantity;
    }

    public int getCompassQuantity() {
        return compassQuantity;
    }

    public void setCompassQuantity(int compassQuantity) {
        this.compassQuantity = compassQuantity;
    }

    public int getPencilQuantity() {
        return pencilQuantity;
    }

    public void setPencilQuantity(int pencilQuantity) {
        this.pencilQuantity = pencilQuantity;
    }

    public int getGlassesQuantity() {
        return glassesQuantity;
    }

    public void setGlassesQuantity(int glassesQuantity) {
        this.glassesQuantity = glassesQuantity;
    }

    public int getPuzzleQuantity() {
        return puzzleQuantity;
    }

    public void setPuzzleQuantity(int puzzleQuantity) {
        this.puzzleQuantity = puzzleQuantity;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getUsbQuantity() {
        return usbQuantity;
    }

    public void setUsbQuantity(int usbQuantity) {
        this.usbQuantity = usbQuantity;
    }

    public int getCheatQuantity() {
        return cheatQuantity;
    }

    public void setCheatQuantity(int cheatQuantity) {
        this.cheatQuantity = cheatQuantity;
    }
}
