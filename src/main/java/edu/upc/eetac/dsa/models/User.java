package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.utils.RandomUtils;

public class User {
    private String ID;
    private String uname;
    private String pswrd;

    public User(){
        this.pswrd = RandomUtils.getRandID();
        this.ID = RandomUtils.getRandID();
    }

    public User(String uname){
        super();
        this.uname = uname;
    }

    public User(String uname, String pswrd){
        this.ID = RandomUtils.getRandID();
        this.uname = uname;
        this.pswrd = pswrd;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }
}
