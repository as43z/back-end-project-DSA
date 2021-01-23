package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.Item;
import edu.upc.eetac.dsa.models.Maps;
import edu.upc.eetac.dsa.models.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import edu.upc.eetac.dsa.utils.ItemDAOImpl;
import edu.upc.eetac.dsa.utils.UserDAOImpl;
import edu.upc.eetac.dsa.utils.MapsDAOImpl;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager{
    private static final Logger log = Logger.getLogger(ManagerImpl.class);
    private UserDAOImpl uManager = new UserDAOImpl();
    private ItemDAOImpl iManager = new ItemDAOImpl();
    private MapsDAOImpl mManager = new MapsDAOImpl();

    private HashMap<String, User> userList;

    // singleton
    private static Manager instance;

    public static Manager getInstance(){
        if(instance == null) instance = new ManagerImpl();

        return instance;
    }

    private ManagerImpl(){
        this.userList = new HashMap<>();
    }
    //end singleton

    public List<User> getUserList() {
        return uManager.getUsers();
    }

    @Override
    public LinkedList<User> getUsers(){
        return new LinkedList<>(uManager.getUsers());
    }

    @Override
    public LinkedList<Maps> getMaps() {
        return new LinkedList<>(mManager.getMaps());
    }

    /**
     * Funcion para loggear a un usuario.
     * @return usuario, si se ha loggeado devolverá un usuario,
     * si no se ha podido loggear devuelve null.
     */
    @Override
    public User signIN(String uname, String pswrd) {
        User u = null;
        List<User> uList = uManager.getUsers();

        int found = 0;
        int i = 0;
        while(found == 0){
            log.info(uList.get(i).getUname() + " " + uname + " " + uList.get(i).getPswrd() + " " + pswrd + " " + i);
            if(uList.get(i).getUname().equals(uname)&&uList.get(i).getPswrd().equals(pswrd)){
                u = uList.get(i);
                found = 1;
            }
            i++;
        }

        return u;
    }

    /**
    * Funcion para registrar a un usuario.
    * @return usuario, si se ha registrado devolverá un usuario,
     * si no se ha podido registrar devuelve null.
    */
    @Override
    public User signUP(String uname, String pswrd, String email) {
        User u = null;
        List<User> uList = uManager.getUsers();

        for(User uConn : uList){
            log.info(uConn.getID() + " " + uConn.getUname() + " " + uConn.getEmail() + " " + uConn.getPswrd());
        }

        if(uList.size() == 0){
            //si no hay usuarios añadelo
            log.info("No users, adding one.");
            u = new User(uname, pswrd, email);
            uManager.addUser(u.getID(), u.getUname(), u.getPswrd(), u.getEmail());
        } else {
            log.info("List already has users.");
            User u2 = null;
            for(User uConn : uList){
                log.info("Comparing " + uname + " with " + uConn.getUname());
                if(uConn.getUname().equals(uname)){
                    log.info("User already exist.");
                    u2 = uConn;
                } else if(uConn.getEmail().equals(email)) {
                    log.info("User already exist.");
                    u2 = uConn;
                }
            }

            if(u2 == null){
                log.info("User, does not exist. Adding User");
                u = new User(uname, pswrd, email);
                uManager.addUser(u.getID(), u.getUname(), u.getPswrd(), u.getEmail());
            }
        }

        return u;
    }

    @Override
    public Item registerItem(String itemID, String name, String description, String qualityUpdater, int quantityUpdater, int price, String image) {
        Item i = null;
        List<Item> iList = iManager.getItems();

        if(iList.size() == 0){
            //si no hay usuarios añadelo
            log.info("No items, adding one.");
                i = new Item(itemID, name, description, qualityUpdater, quantityUpdater, price, image);
                iManager.addItem(i);
        } else {
            log.info("Already Items in use.");
            Item i2 = null;
            for (Item item : iList) {
                if (item.getName().equals(name)) {
                    log.info("Item already exist.");
                    i2 = item;
                } else if (item.getID().equals(itemID)){
                    log.info("Item already exist.");
                    i2 = item;
                }
            }

            if (i2 == null) {
                log.info("Item does not exist. Registering Item.");
                i = new Item(itemID, name, description, qualityUpdater, quantityUpdater, price, image);
                iManager.addItem(i);
            }
        }
        return i;
    }

    @Override
    public Maps registerMap(String ID, String name, String vectMap) {

    }

    @Override
    public Item getItem(String itemID) {
        return iManager.getItem(itemID);
    }

    @Override
    public Maps getMap(String MapID) {this. }

    @Override
    public User getUser(String ID) {
        return uManager.getUser(ID);
    }

    @Override
    public LinkedList<Item> getItems() {
        return new LinkedList<>(iManager.getItems());
    }

    public void tearDown(){
        this.userList.clear();
    }
}
