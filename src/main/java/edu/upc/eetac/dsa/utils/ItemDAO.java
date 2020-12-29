package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Item;

import java.util.List;

public interface ItemDAO {
    String addItem(Item item);
    Item getItem(String itemID);
    void updateItem(String ID, String name, String description);
    void deleteItem(String itemID);
    List<Item> getItems();
}
