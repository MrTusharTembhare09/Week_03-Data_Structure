package singlylinkedlistproblems.inventorymanagementsystem;

// Main class to test the Inventory Management System
public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();

        // Adding items
        system.addItemAtBeginning("Laptop", 101, 10, 1200.0);
        system.addItemAtEnd("Mouse", 102, 50, 25.0);
        system.addItemAtPosition("Keyboard", 103, 30, 50.0, 2);

        // Displaying inventory
        system.displayInventory();

        // Searching items
        system.searchItemByID(102);
        system.searchItemByName("Laptop");

        // Updating item quantity
        system.updateItemQuantity(101, 15);

        // Calculating total inventory value
        system.calculateTotalInventoryValue();

        // Sorting inventory by Item Name
        system.sortInventoryByName();
        system.displayInventory();

        // Sorting inventory by Price
        system.sortInventoryByPrice();
        system.displayInventory();

        // Removing an item
        system.removeItemByID(103);

        // Displaying inventory after removal
        system.displayInventory();
    }
}
