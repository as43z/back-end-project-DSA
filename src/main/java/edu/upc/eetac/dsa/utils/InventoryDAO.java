package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Inventory;

import java.util.List;

public interface InventoryDAO {

    Inventory addInventory(Inventory inventory);
    Inventory getInventory(String inventoryID);
    void updateInventory(String ID, int turtleQuantity, int coffQuantity, int redbullQuantity, int pillsQuantity, int calculatorQuantity, int ruleQuantity, int compassQuantity, int pencilQuantity, int glassesQuantity, int puzzleQuantity, int bookQuantity, int usbQuantity, int cheatQuantity);
    void deleteInventory(String inventoryID);
    List<Inventory> getInventorys();
}
