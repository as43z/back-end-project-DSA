package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import edu.upc.eetac.dsa.utils.*;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager{
    private static final Logger log = Logger.getLogger(ManagerImpl.class);
    private UserDAOImpl uManager = new UserDAOImpl();
    private ItemDAOImpl iManager = new ItemDAOImpl();
    private MapsDAOImpl mManager = new MapsDAOImpl();
    private GameDAOImpl gManager = new GameDAOImpl();
    private InventoryDAOImpl inManager = new InventoryDAOImpl();
    private AchievementsDAOImpl aManager = new AchievementsDAOImpl();

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
    public LinkedList<Maps> getMapsList() {
        return new LinkedList<>(mManager.getMapsList());
    }

    @Override
    public User updateUser(User user) {
        return uManager.updateUser(user);
    }

    @Override
    public Inventory updateInventory(Inventory inventory, String userID) {
        inventory.setID(this.getUserInventory(userID).getID());
        return inManager.updateInventory(inventory);
    }

    @Override
    public Achievements updateAchievements(Achievements achievements, String userID) {
        achievements.setID(this.getUserAchievements(userID).getID());
        return aManager.updateAchievements(achievements.getID(),
                achievements.getCalcAch(), achievements.getElectronicsAch(), achievements.getCommsAch(),
                achievements.getOescAch(), achievements.getDsaAch(), achievements.getAeroAch(), achievements.getTfgAch());
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
                log.info("id of user " + uList.get(i).getID());
                u = uList.get(i);
                log.info("id of user " + u.getID());
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
            Inventory i = new Inventory(0,0,0,0,0,0,0,
                    0, 0, 0, 0, 0, 0);
            Achievements a = new Achievements(0,0,0,0,0,0,0);
            Maps m = new Maps("1","Lago","2");
            Game g = new Game(i.getID(), a.getID(),m.getID());
            u.setCash(0);
            u.setIdGame(g.getID());
            inManager.addInventory(i);
            aManager.addAchievements(a);
            gManager.addGame(g);
            uManager.addUser(u);
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
                Inventory i = new Inventory(0,0,0,0,0,0,0,
                        0, 0, 0, 0, 0, 0);
                Achievements a = new Achievements(0,0,0,0,0,0,0);
                Maps m = new Maps("1","Lago","2");
                Game g = new Game(i.getID(), a.getID(),m.getID());
                u.setCash(0);
                u.setIdGame(g.getID());
                uManager.addUser(u);
                inManager.addInventory(i);
                aManager.addAchievements(a);
                gManager.addGame(g);
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
    public Maps registerMap(String MapsID, String name, String vectMap) {
        Maps i = null;
        List<Maps> mList = mManager.getMapsList();

        if(mList.size() == 0){
            i = new Maps(MapsID,name,vectMap);
            mManager.addMaps(i);
        }
        else {
            Maps i2 = null;
            for (Maps maps : mList) {
                if (maps.getName().equals(name)) {
                    i2 = maps;
                } else if (maps.getID().equals(MapsID)){
                    i2 = maps;
                }
            }

            if (i2 == null) {
                i = new Maps(MapsID,name,vectMap);
                mManager.addMaps(i);
            }
        }
        return i;
    }

    @Override
    public Item getItem(String itemID) {
        return iManager.getItem(itemID);
    }

    @Override
    public Maps getMaps(String MapID) {
        return mManager.getMaps(MapID);
    }

    @Override
    public User getUser(String ID) {
        log.info("Searching user " + ID);
        return uManager.getUser(ID);
    }

    @Override
    public Inventory getUserInventory(String userID) {
        Game g = this.getUserGame(userID);
        return inManager.getInventory(g.getIdObjects());
    }

    @Override
    public Game getUserGame(String userID) {
        User u = this.getUser(userID);
        return gManager.getGame(u.getIdGame());
    }

    @Override
    public Achievements getUserAchievements(String userID) {
        Game g = this.getUserGame(userID);
        return aManager.getAchievements(g.getIdAchievements());
    }

    @Override
    public LinkedList<Item> getItems() {
        return new LinkedList<>(iManager.getItems());
    }

    public void tearDown(){
        this.userList.clear();
    }
}
