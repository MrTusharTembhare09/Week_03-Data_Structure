package singlylinkedlistproblems.inventorymanagementsystem;

// Node class representing an item in the inventory
class ItemNode {
    String itemName;
    int itemID;
    int quantity;
    double price;
    ItemNode next;

    // Constructor to initialize an item node
    public ItemNode(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
