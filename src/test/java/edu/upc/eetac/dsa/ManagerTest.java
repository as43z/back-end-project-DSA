package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.models.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.junit.*;

import java.util.LinkedList;
import java.util.List;

public class ManagerTest {
    private Manager manager;
    private static Logger log = Logger.getLogger(Manager.class);

    @Before
    public void setUp(){
        this.manager = ManagerImpl.getInstance();
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }

    @After
    public void tearDown(){
        this.manager.tearDown();
    }

    @Test
    public void noUsersTest(){
        Assert.assertEquals(0, this.manager.getUsers().size());
    }

    @Test
    public void addUsersTest(){
        this.manager.signUP("test", "test");
        Assert.assertEquals(1, this.manager.getUsers().size());
    }

    @Test
    public void checkExistTest(){
        User u = this.manager.signUP("test", "test");
        Assert.assertEquals(u.getID(), this.manager.getUsers().get(0).getID());
    }

    @Test
    public void doubleRegisterTest(){
        User u = this.manager.signUP("test", "test");
        Assert.assertEquals(null, this.manager.signUP("test", "test"));
    }
}
