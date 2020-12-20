package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.models.User;

public interface UserDAO
{
    String addUser(String ID, String uname, String pswrd, String email);
    User getUser(String userID);
    void updateUser(String ID, String uname, String pswrd, String email);
    void deleteUser(String userID);
  //  List<User> getUsers();
  //  List <User> getUserByDept(int deptId);
}
