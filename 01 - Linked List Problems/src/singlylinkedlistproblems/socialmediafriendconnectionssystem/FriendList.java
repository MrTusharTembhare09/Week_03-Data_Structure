package singlylinkedlistproblems.socialmediafriendconnectionssystem;

// Nested linked list class for managing friend IDs
class FriendList {
    FriendNode head;

    // Constructor to initialize an empty friend list
    public FriendList() {
        this.head = null;
    }

    // Adding a friend ID to the list
    public void addFriend(int friendID) {
        FriendNode newNode = new FriendNode(friendID);
        if (head == null) {
            head = newNode; // If list is empty, set head to the new node
        } else {
            FriendNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Add the new node at the end
        }
    }

    // Removing a friend ID from the list
    public void removeFriend(int friendID) {
        if (head == null) {
            return; // If list is empty, nothing to remove
        }
        if (head.friendID == friendID) {
            head = head.next; // Remove the first node if it matches
            return;
        }
        FriendNode current = head;
        while (current.next != null) {
            if (current.next.friendID == friendID) {
                current.next = current.next.next; // Remove the node with the matching ID
                return;
            }
            current = current.next;
        }
    }

    // Checking if a friend ID exists in the list
    public boolean containsFriend(int friendID) {
        FriendNode current = head;
        while (current != null) {
            if (current.friendID == friendID) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Displaying all friend IDs in the list
    public void displayFriends() {
        FriendNode current = head;
        while (current != null) {
            System.out.print(current.friendID + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Counting the number of friends in the list
    public int countFriends() {
        int count = 0;
        FriendNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
