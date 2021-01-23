package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.Inventory;

import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {
    @Override
    public Inventory addInventory(Inventory inventory) {
        Session session =  null;

        try{
            session = FactorySession.openSession();
            session.save(inventory);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return inventory;
    }

    @Override
    public Inventory getInventory(String inventoryID) {

        Session session = null;
        Inventory i = null;
        try {
            session = FactorySession.openSession();
            i = (Inventory) session.get(Inventory.class, inventoryID);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return i;
    }

    @Override
    public void updateInventory(String ID, int turtleQuantity, int coffQuantity, int redbullQuantity, int pillsQuantity, int calculatorQuantity, int ruleQuantity, int compassQuantity, int pencilQuantity, int glassesQuantity, int puzzleQuantity, int bookQuantity, int usbQuantity, int cheatQuantity) {

    }

    @Override
    public void deleteInventory(String inventoryID) {

    }

    @Override
    public List<Inventory> getInventorys() {
        Session session = null;
        List<Inventory> lInventory = null;
        try{
            session = FactorySession.openSession();
            lInventory = session.findAll(Inventory.class);

        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lInventory;
    }
}
