package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.Item;

import edu.upc.eetac.dsa.models.Maps;
import org.apache.log4j.Logger;

import java.util.List;

public class ItemDAOImpl implements ItemDAO{
    private static Logger log = Logger.getLogger(ItemDAOImpl.class);

    @Override
    public Item addItem(Item item) {
        log.info("Wanting to add ITEM: " + item.getName());
        Session session =  null;

        try{
            session = FactorySession.openSession();
            session.save(item);
            log.info("Item Saved.");
        } catch(Exception ex){
            log.info("Could not proceed with the registration of the item.");
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public Item getItem(String itemID) {
        log.info("Searching for Item: " + itemID);
        Session session = null;
        Item i = null;
        try {
            session = FactorySession.openSession();
            i = (Item)session.get(Item.class, itemID);
            log.info("Item retrieved successfully (" + i.getName() + ").");
        }
        catch (Exception e) {
            // LOG
            log.info("Could not proceed with the retrieving of the item.");
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return i;
    }

    @Override
    public void updateItem(String ID, String name, String description)
    {
        Item item= this.getItem(ID);
        item.setName(name);
        item.setDescription(description);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(item);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteItem(String itemID) {

        Item item= this.getItem(itemID);
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
    public List<Item> getItems() {
        log.info("Retrieving all items.");
        Session session = null;
        List<Item> lItems = null;
        try{
            session = FactorySession.openSession();
            lItems = session.findAll(Item.class);
            log.info("Items retrieved.");
        } catch (Exception ex){
            log.info("Something bad happened while retrieving the list of objects.");
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return lItems;
    }
}
