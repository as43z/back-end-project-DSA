package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.*;
import edu.upc.eetac.dsa.models.User;
import java.util.List;

public interface UserDAO
{
    int addUser(String ID, String uname, String pswrd, String email);
    User getUser(int employeeID);
    void updateUser(int employeeID, String name, String surname, double salary);
    void deleteUser(int employeeID);
  //  List<User> getUsers();
  //  List <User> getUserByDept(int deptId);
}
