package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Inventory;

import java.util.List;

public interface InventoryDAO {

    Inventory addInventory(Inventory inventory);
    Inventory getInventory(String inventoryID);
    Inventory updateInventory(Inventory inventory);
    void deleteInventory(String inventoryID);
    List<Inventory> getInventorys();
}
