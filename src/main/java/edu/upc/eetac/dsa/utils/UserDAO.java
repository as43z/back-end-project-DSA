package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.models.User;

import java.util.List;

public interface UserDAO
{
    String addUser(User u);
    User getUser(String userID);
    User updateUser(User user);
    void updateSingleElement(String prop, Object value, String ID);
    void deleteUser(String userID);
    List<User> getUsers();
  //  List <User> getUserByDept(int deptId);
}
