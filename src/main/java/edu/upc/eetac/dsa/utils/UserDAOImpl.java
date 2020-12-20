package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.User;
import edu.upc.eetac.dsa.*;
import org.apache.log4j.Logger;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final Logger log = Logger.getLogger(UserDAOImpl.class);

    @Override
    public String addUser(String userID, String uname, String pswrd, String email) {
        Session session = null;

        try {
            session = FactorySession.openSession();
            User u = new User(userID, uname, pswrd, email);
            session.save(u);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userID;
    }

    @Override
    public User getUser(String userID) {
        Session session = null;
        User u = null;
        try {
            session = FactorySession.openSession();
            u = (User)session.get(User.class, userID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return u;
    }

    @Override
    public void updateUser(String userID, String uname, String pswrd, String email) {
        User u = this.getUser(userID);
        u.setUname(uname);
        u.setPswrd(pswrd);
        u.setEmail(email);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(String userID) {
        User u = this.getUser(userID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }

    @Override
    public List<User> getUsers() {
        Session session = null;
        List<User> userList =null;
        try {
            session = FactorySession.openSession();
            userList = session.findAll(User.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userList;
    }

/*
    public List<User> getUserByDept(int deptID) {

        Session session = null;
        List<User> employeeList=null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("deptID", deptID);

            userList = session.findAll(User.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return userList;
    } */
}
