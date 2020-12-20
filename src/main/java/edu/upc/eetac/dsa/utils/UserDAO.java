package edu.upc.eetac.dsa.utils;
import edu.upc.eetac.dsa.*;

public interface UserDAO
{

    public int addUser(String name, String surname, double salary);
    public User getUser(int employeeID);
    public void updateUser(int employeeID, String name, String surname, double salary);
    public void deleteUser(int employeeID);
    public List<User> getUsers();
    public List <User> getEmployeeByDept(int deptId);

}
