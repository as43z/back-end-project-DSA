package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.Inventory;
import edu.upc.eetac.dsa.models.Item;

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
    public Inventory updateInventory(Inventory inventory) {
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
    public void deleteInventory(String inventoryID) {

        Inventory inventory= this.getInventory(inventoryID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Item.class);
        }
        catch (Exception e) {
        }
        finally {
            session.close();
        }
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
