package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import edu.upc.eetac.dsa.utils.*;
import io.swagger.models.auth.In;
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
    public Game updateGame(Game game) {
        return this.gManager.updateGame(game.getID(), game.getIdObjects(),
                game.getIdAchievements(), game.getIdMap());
    }

    @Override
    public User updateUser(User user) {
        log.info(user.getID());
        log.info(user.getUname());
        if(user.getUname() == null){
            user.setUname(this.getUser(user.getID()).getUname());
            log.info(user.getUname());
        }
        log.info(user.getPswrd());
        if(user.getPswrd() == null){
            user.setPswrd(this.getUser(user.getID()).getPswrd());
            log.info(user.getPswrd());
        }
        log.info(user.getCash());
        if(user.getCash() == 0){
            user.setCash(this.getUser(user.getID()).getCash());
            log.info(user.getCash());
        }
        log.info(user.getEmail());
        if(user.getEmail() == null){
            user.setEmail(this.getUser(user.getID()).getEmail());
            log.info(user.getEmail());
        }
        log.info(user.getIdGame());
        if(user.getIdGame() == null){
            user.setIdGame(this.getUser(user.getID()).getIdGame());
            log.info(user.getIdGame());
        }
        return uManager.updateUser(user);
    }

    @Override
    public Inventory updateInventory(Inventory inventory, String userID) {
        Inventory i = this.getUserInventory(userID);
        if (i == null){
            return null;
        } else {
            inventory.setID(i.getID());
            return inManager.updateInventory(inventory);
        }
    }

    @Override
    public Achievements updateAchievements(Achievements achievements, String userID) {
        Achievements ach = this.getUserAchievements(userID);
        if(ach == null){
            return null;
        } else {
            achievements.setID(this.getUserAchievements(userID).getID());
            return aManager.updateAchievements(achievements.getID(),
                    achievements.getCalcAch(), achievements.getElectronicsAch(), achievements.getCommsAch(),
                    achievements.getOescAch(), achievements.getDsaAch(), achievements.getAeroAch(), achievements.getTfgAch());
        }
    }

    @Override
    public int updateUserSingleElement(String prop, Object value, String ID) {
        if ((this.uManager.updateSingleElement(prop, value, ID) == 1)&&(this.getUser(ID).getUname()!=null)){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public User reiniciarGame(String userID) {
        User u = this.getUser(userID);
        if(u == null) {
            return null;
        } else {
            this.updateUserSingleElement("cash", 20, userID);
            Game g = this.getUserGame(userID);
            Inventory i = new Inventory(this.getUserInventory(userID).getID(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            Achievements ach = new Achievements(this.getUserAchievements(userID).getID(), 0, 0, 0, 0, 0, 0, 0);
            this.updateAchievements(ach, userID);
            this.updateInventory(i, userID);
            log.info(g.getIdAchievements() + " " + g.getIdObjects());
            this.updateUserMap(userID, "1");
            return u;
        }
    }

    @Override
    public User updateUserMap(String userID, String mapID) {
        User u = this.getUser(userID);
        if(u==null) {
            return null;
        } else {
            Game g = this.getUserGame(userID);
            g.setIdMap(mapID);
            log.info(mapID);
            log.info(g.getIdAchievements() + " " + g.getIdObjects());
            Game game = this.gManager.updateGame(g.getID(), g.getIdObjects(),
                    g.getIdAchievements(), g.getIdMap());
            log.info(g.getIdAchievements() + " " + g.getIdObjects());
            if(game == null){
                return null;
            }
            return u;
        }
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
            u.setCash(20);
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
                u.setCash(20);
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
    public Item registerItem(String itemID, String name, String description,int price, String image) {
        Item i = null;
        List<Item> iList = iManager.getItems();

        if(iList.size() == 0){
            //si no hay usuarios añadelo
            log.info("No items, adding one.");
                i = new Item(itemID, name, description, price, image);
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
                i = new Item(itemID, name, description, price, image);
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
        if(g == null){
            return null;
        }
        return inManager.getInventory(g.getIdObjects());
    }

    @Override
    public Game getUserGame(String userID) {
        User u = this.getUser(userID);
        if((u == null)||(u.getUname() == null)){
            return null;
        }
        return gManager.getGame(u.getIdGame());
    }

    @Override
    public Achievements getUserAchievements(String userID) {
        Game g = this.getUserGame(userID);
        if (g == null){
            return null;
        }
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
