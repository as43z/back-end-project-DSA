package edu.upc.eetac.dsa.models;

public class User {
    private String uname;
    private String pswrd;

    public User(){
        this.pswrd = "";
    }

    public User(String uname){
        super();
        this.uname = uname;
    }

    public User(String uname, String pswrd){
        this.uname = uname;
        this.pswrd = pswrd;
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
