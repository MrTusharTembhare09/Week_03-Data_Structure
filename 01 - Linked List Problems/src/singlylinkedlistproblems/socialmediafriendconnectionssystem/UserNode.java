package singlylinkedlistproblems.socialmediafriendconnectionssystem;

import java.util.HashSet;
import java.util.Set;

// Node class representing a user in the social media system
class UserNode {
    int userID;
    String name;
    int age;
    UserNode next;
    FriendList friends; // Nested linked list for friend IDs

    // Constructor to initialize a user node
    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.next = null;
        this.friends = new FriendList();
    }
}
