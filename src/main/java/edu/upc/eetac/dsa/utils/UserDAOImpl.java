package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.User;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO
{
    public int addUser(String name, String surname, double salary) {
        Session session = null;
        int employeeID = 0;
        try {
            session = FactorySession.openSession();
            User employee = new User(name, surname, salary);
            session.save(employee);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return employeeID;
    }


    public User getUser(int employeeID) {
        Session session = null;
        Employee employee = null;
        try {
            session = FactorySession.openSession();
            employee = (User)session.get(User.class, employeeID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return employee;
    }


    public void updateUser(int employeeID, String name, String surname, double salary) {
        User u = this.getUser(employeeID);
        u.setName(name);
        u.setSurname(surname);
        u.setSalary(salary);

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

    public void deleteUser(int employeeID) {
        User u = this.getEmploye(employeeID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Employee.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }


    public List<Employee> getEmployees() {
        Session session = null;
        List<Employee> employeeList=null;
        try {
            session = FactorySession.openSession();
            employeeList = session.findAll(Employee.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return employeeList;
    }


    public List<Employee> getEmployeeByDept(int deptID) {

        Session session = null;
        List<Employee> employeeList=null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("deptID", deptID);

            employeeList = session.findAll(Employee.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return employeeList;
    }

}
