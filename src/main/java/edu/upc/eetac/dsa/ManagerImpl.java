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

    public List<User> getUserList() {
        return uManager.getUsers();
    }

    @Override
    public LinkedList<User> getUsers(){
        return new LinkedList<>(uManager.getUsers());
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
    public User getUser(String ID) {
        return uManager.getUser(ID);
    }

    public void tearDown(){
        this.userList.clear();
    }
}
