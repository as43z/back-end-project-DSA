package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.*;

import java.util.LinkedList;

public interface Manager {

    // login y register
    public User signIN(String uname, String pswrd);
    public User signUP(String uname, String pswrd, String email);

    // item register
    public Item registerItem(String itemID, String name, String description, String qualityUpdater, int quantityUpdater, int price, String image);

    //Maps register
    public Maps registerMap(String ID, String name, String vectMap);

    // gets
    public Item getItem(String itemID);
    public Maps getMap(String MapID);
    public User getUser(String uname);
    public LinkedList<Item> getItems();
    public LinkedList<User> getUsers();
    public LinkedList<Maps> getMaps();

    // teardown
    public void tearDown();
}
