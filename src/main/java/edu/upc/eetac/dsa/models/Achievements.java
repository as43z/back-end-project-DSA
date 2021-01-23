package edu.upc.eetac.dsa.models;

public class Achievements {
    private String ID;
    private boolean calcAch;
    private boolean electronicsAch;
    private boolean commsAch;
    private boolean oescAch;
    private boolean dsaAch;
    private boolean aeroAch;
    private boolean tfgAch;

    public Achievements(String ID, boolean calcAch, boolean electronicsAch, boolean commsAch, boolean oescAch, boolean dsaAch, boolean aeroAch, boolean tfgAch) {
        this.ID = ID;
        this.calcAch = calcAch;
        this.electronicsAch = electronicsAch;
        this.commsAch = commsAch;
        this.oescAch = oescAch;
        this.dsaAch = dsaAch;
        this.aeroAch = aeroAch;
        this.tfgAch = tfgAch;
    }

    public String getId() {
        return ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }

    public boolean isCalcAch() {
        return calcAch;
    }

    public void setCalcAch(boolean calcAch) {
        this.calcAch = calcAch;
    }

    public boolean isElectronicsAch() {
        return electronicsAch;
    }

    public void setElectronicsAch(boolean electronicsAch) {
        this.electronicsAch = electronicsAch;
    }

    public boolean isCommsAch() {
        return commsAch;
    }

    public void setCommsAch(boolean commsAch) {
        this.commsAch = commsAch;
    }

    public boolean isOescAch() {
        return oescAch;
    }

    public void setOescAch(boolean oescAch) {
        this.oescAch = oescAch;
    }

    public boolean isDsaAch() {
        return dsaAch;
    }

    public void setDsaAch(boolean dsaAch) {
        this.dsaAch = dsaAch;
    }

    public boolean isAeroAch() {
        return aeroAch;
    }

    public void setAeroAch(boolean aeroAch) {
        this.aeroAch = aeroAch;
    }

    public boolean isTfgAch() {
        return tfgAch;
    }

    public void setTfgAch(boolean tfgAch) {
        this.tfgAch = tfgAch;
    }
}
