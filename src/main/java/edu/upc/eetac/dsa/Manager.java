package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.*;

import java.util.LinkedList;

public interface Manager {
    // login y register
    public User signIN(String uname, String pswrd);
    public User signUP(String uname, String pswrd);

    // gets
    public User getUser(String uname);
    public LinkedList<User> getUsers();

    // teardown
    public void tearDown();
}
