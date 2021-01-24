package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.models.User;

import java.util.List;

public interface UserDAO
{
    String addUser(User u);
    User getUser(String userID);
    void updateUser(String ID, String uname, String pswrd, String email,String idGame, int cash);
    void deleteUser(String userID);
    List<User> getUsers();
  //  List <User> getUserByDept(int deptId);
}
