package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import edu.upc.eetac.dsa.utils.UserDAOImpl;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager{
    private static final Logger log = Logger.getLogger(ManagerImpl.class);
    private UserDAOImpl uManager = new UserDAOImpl();

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

    public HashMap<String, User> getUserList() {
        return userList;
    }

    public void setUserList(HashMap<String, User> userList) {
        this.userList = userList;
    }

    @Override
    public LinkedList<User> getUsers(){
        return new LinkedList<User>(this.userList.values());
    }

    /**
     * Funcion para loggear a un usuario.
     * @return usuario, si se ha loggeado devolverá un usuario,
     * si no se ha podido loggear devuelve null.
     */
    @Override
    public User signIN(String uname, String pswrd) {
        User u = null;

        for(User uConn : userList.values()){
            if(uConn.getUname().equals(uname)&&uConn.getPswrd().equals(pswrd))
                u = uConn;
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

        if(userList.size() == 0){
            //si no hay usuarios añadelo
            log.info("No users, adding one.");
            u = new User(uname, pswrd, email);
            userList.put(u.getID(), u);
            uManager.addUser(u.getID(), u.getUname(), u.getPswrd(), u.getEmail());
        } else {
            log.info("List already has users.");
            User u2 = null;
            for(User uConn : userList.values()){
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
                userList.put(u.getID(), u);
                uManager.addUser(u.getID(), u.getUname(), u.getPswrd(), u.getEmail());
            }
        }

        return u;
    }

    @Override
    public User getUser(String ID) {
        return userList.get(ID);
    }

    public void tearDown(){
        this.userList.clear();
    }
}
