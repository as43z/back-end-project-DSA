package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager{
    private static final Logger log = Logger.getLogger(ManagerImpl.class);

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

    @Override
    public User signIN(String uname, String pswrd) {
        User u = null;

        //si existe en la lista, ya está registrado.
        if (userList.get(new User(uname, pswrd)) != null) u = new User(uname, pswrd);

        return u;
    }

    @Override
    public User signUP(String uname, String pswrd) {
        User u = null;

        if( userList.size() == 0){
            //si no hay usuarios añadelo
            u = new User(uname, pswrd);
            userList.put(u.getID(), u);
        } else {
            if(userList.get(new User(uname, pswrd)) == null){
                //si el usuario no existe en la lista, añadelo
                u = new User(uname, pswrd);
                userList.put(u.getID(), u);
            }
        }

        return u;
    }

    @Override
    public User getUser(String ID) {
        return userList.get(ID);
    }
}
