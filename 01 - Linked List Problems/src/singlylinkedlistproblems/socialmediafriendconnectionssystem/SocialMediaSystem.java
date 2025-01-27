package singlylinkedlistproblems.socialmediafriendconnectionssystem;

import java.util.HashSet;
import java.util.Set;

// Singly Linked List class for managing users
class SocialMediaSystem {
    private UserNode head;

    // Constructor to initialize an empty list
    public SocialMediaSystem() {
        this.head = null;
    }

    // Adding a user to the system
    public void addUser(int userID, String name, int age) {
        UserNode newNode = new UserNode(userID, name, age);
        if (head == null) {
            head = newNode; // If list is empty, set head to the new node
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Add the new node at the end
        }
        System.out.println("Adding user: " + name + " (ID: " + userID + ")");
    }

    // Finding a user by User ID
    private UserNode findUserByID(int userID) {
        UserNode current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Adding a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friends.addFriend(userID2); // Add user2 to user1's friend list
        user2.friends.addFriend(userID1); // Add user1 to user2's friend list
        System.out.println("Adding friend connection between User " + userID1 + " and User " + userID2);
    }

    // Removing a friend connection between two users
    public void removeFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friends.removeFriend(userID2); // Remove user2 from user1's friend list
        user2.friends.removeFriend(userID1); // Remove user1 from user2's friend list
        System.out.println("Removing friend connection between User " + userID1 + " and User " + userID2);
    }

    // Finding mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        Set<Integer> mutualFriends = new HashSet<>();
        FriendNode current = user1.friends.head;
        while (current != null) {
            if (user2.friends.containsFriend(current.friendID)) {
                mutualFriends.add(current.friendID); // Add mutual friend to the set
            }
            current = current.next;
        }
        System.out.println("Mutual friends between User " + userID1 + " and User " + userID2 + ": " + mutualFriends);
    }

    // Displaying all friends of a specific user
    public void displayFriends(int userID) {
        UserNode user = findUserByID(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of User " + userID + ":");
        user.friends.displayFriends();
    }

    // Searching for a user by Name
    public void searchUserByName(String name) {
        UserNode current = head;
        boolean found = false;
        System.out.println("Searching for user with name: " + name);
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("Found: " + current.name + " (ID: " + current.userID + ", Age: " + current.age + ")");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("User not found with name: " + name);
        }
    }

    // Searching for a user by User ID
    public void searchUserByID(int userID) {
        UserNode user = findUserByID(userID);
        if (user == null) {
            System.out.println("User not found with ID: " + userID);
        } else {
            System.out.println("Found: " + user.name + " (ID: " + user.userID + ", Age: " + user.age + ")");
        }
    }

    // Counting the number of friends for a specific user
    public void countFriends(int userID) {
        UserNode user = findUserByID(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        int count = user.friends.countFriends();
        System.out.println("User " + userID + " has " + count + " friends.");
    }

    // Displaying all users in the system
    public void displayAllUsers() {
        UserNode current = head;
        System.out.println("Displaying all users:");
        while (current != null) {
            System.out.println(current.name + " (ID: " + current.userID + ", Age: " + current.age + ")");
            current = current.next;
        }
    }
}
