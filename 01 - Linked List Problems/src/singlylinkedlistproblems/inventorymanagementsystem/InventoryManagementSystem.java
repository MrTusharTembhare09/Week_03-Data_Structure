package singlylinkedlistproblems.inventorymanagementsystem;

// Singly Linked List class for managing inventory
class InventoryManagementSystem {
    private ItemNode head;

    // Constructor to initialize an empty list
    public InventoryManagementSystem() {
        this.head = null;
    }

    // Adding an item at the beginning of the list
    public void addItemAtBeginning(String itemName, int itemID, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemID, quantity, price);
        newNode.next = head;
        head = newNode; // Update head to the new node
        System.out.println("Adding item at the beginning: " + itemName);
    }

    // Adding an item at the end of the list
    public void addItemAtEnd(String itemName, int itemID, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemID, quantity, price);
        if (head == null) {
            head = newNode; // If list is empty, set head to the new node
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Add the new node at the end
        }
        System.out.println("Adding item at the end: " + itemName);
    }

    // Adding an item at a specific position in the list
    public void addItemAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be greater than 0.");
            return;
        }
        if (position == 1) {
            addItemAtBeginning(itemName, itemID, quantity, price); // Add at the beginning if position is 1
            return;
        }
        ItemNode newNode = new ItemNode(itemName, itemID, quantity, price);
        ItemNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position exceeds the length of the list.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Adding item at position " + position + ": " + itemName);
    }

    // Removing an item by its Item ID
    public void removeItemByID(int itemID) {
        if (head == null) {
            System.out.println("Inventory is empty. No item to remove.");
            return;
        }
        if (head.itemID == itemID) {
            head = head.next; // Remove the first node if it matches
            System.out.println("Removing item with ID: " + itemID);
            return;
        }
        ItemNode current = head;
        while (current.next != null) {
            if (current.next.itemID == itemID) {
                current.next = current.next.next; // Remove the node with the matching ID
                System.out.println("Removing item with ID: " + itemID);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found with ID: " + itemID);
    }

    // Updating the quantity of an item by its Item ID
    public void updateItemQuantity(int itemID, int newQuantity) {
        ItemNode current = head;
        while (current != null) {
            if (current.itemID == itemID) {
                System.out.println("Updating quantity of item with ID " + itemID + " from " + current.quantity + " to " + newQuantity);
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found with ID: " + itemID);
    }

    // Searching for an item by its Item ID
    public void searchItemByID(int itemID) {
        ItemNode current = head;
        System.out.println("Searching for item with ID: " + itemID);
        while (current != null) {
            if (current.itemID == itemID) {
                System.out.println("Found: " + current.itemName + " (ID: " + current.itemID + "), Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found with ID: " + itemID);
    }

    // Searching for an item by its Item Name
    public void searchItemByName(String itemName) {
        ItemNode current = head;
        boolean found = false;
        System.out.println("Searching for item with name: " + itemName);
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                System.out.println("Found: " + current.itemName + " (ID: " + current.itemID + "), Quantity: " + current.quantity + ", Price: " + current.price);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item not found with name: " + itemName);
        }
    }

    // Calculating and displaying the total value of the inventory
    public void calculateTotalInventoryValue() {
        double totalValue = 0;
        ItemNode current = head;
        while (current != null) {
            totalValue += current.quantity * current.price; // Sum up Quantity * Price for each item
            current = current.next;
        }
        System.out.println("Calculating total inventory value: " + totalValue);
    }

    // Sorting the inventory based on Item Name (ascending order)
    public void sortInventoryByName() {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one item
        }
        head = mergeSortByName(head);
        System.out.println("Sorting inventory by Item Name (ascending order).");
    }

    // Merge sort helper function for sorting by Item Name
    private ItemNode mergeSortByName(ItemNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;
        ItemNode left = mergeSortByName(head);
        ItemNode right = mergeSortByName(nextOfMiddle);
        return mergeByName(left, right);
    }

    // Merge helper function for sorting by Item Name
    private ItemNode mergeByName(ItemNode left, ItemNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ItemNode result;
        if (left.itemName.compareTo(right.itemName) <= 0) {
            result = left;
            result.next = mergeByName(left.next, right);
        } else {
            result = right;
            result.next = mergeByName(left, right.next);
        }
        return result;
    }

    // Sorting the inventory based on Price (ascending order)
    public void sortInventoryByPrice() {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one item
        }
        head = mergeSortByPrice(head);
        System.out.println("Sorting inventory by Price (ascending order).");
    }

    // Merge sort helper function for sorting by Price
    private ItemNode mergeSortByPrice(ItemNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;
        ItemNode left = mergeSortByPrice(head);
        ItemNode right = mergeSortByPrice(nextOfMiddle);
        return mergeByPrice(left, right);
    }

    // Merge helper function for sorting by Price
    private ItemNode mergeByPrice(ItemNode left, ItemNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ItemNode result;
        if (left.price <= right.price) {
            result = left;
            result.next = mergeByPrice(left.next, right);
        } else {
            result = right;
            result.next = mergeByPrice(left, right.next);
        }
        return result;
    }

    // Helper function to get the middle of the linked list
    private ItemNode getMiddle(ItemNode head) {
        if (head == null) {
            return head;
        }
        ItemNode slow = head;
        ItemNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Displaying all items in the inventory
    public void displayInventory() {
        ItemNode current = head;
        System.out.println("Displaying inventory:");
        while (current != null) {
            System.out.println(current.itemName + " (ID: " + current.itemID + "), Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
}
