package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.models.User;

import java.util.List;

public interface UserDAO
{
    String addUser(String ID, String uname, String pswrd, String email);
    User getUser(String userID);
    User updateUser(User u);
    void deleteUser(String userID);
    List<User> getUsers();
  //  List <User> getUserByDept(int deptId);
}
