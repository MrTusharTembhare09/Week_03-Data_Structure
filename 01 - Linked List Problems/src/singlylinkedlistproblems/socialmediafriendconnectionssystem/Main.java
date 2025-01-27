package singlylinkedlistproblems.socialmediafriendconnectionssystem;

// Main class to test the Social Media System
public class Main {
    public static void main(String[] args) {
        SocialMediaSystem system = new SocialMediaSystem();

        // Adding users
        system.addUser(1, "Alice", 25);
        system.addUser(2, "Bob", 30);
        system.addUser(3, "Charlie", 22);
        system.addUser(4, "David", 28);

        // Displaying all users
        system.displayAllUsers();

        // Adding friend connections
        system.addFriendConnection(1, 2);
        system.addFriendConnection(1, 3);
        system.addFriendConnection(2, 4);

        // Displaying friends of a specific user
        system.displayFriends(1);

        // Finding mutual friends
        system.findMutualFriends(1, 2);

        // Searching for a user by name
        system.searchUserByName("Bob");

        // Searching for a user by ID
        system.searchUserByID(3);

        // Counting the number of friends for a user
        system.countFriends(1);

        // Removing a friend connection
        system.removeFriendConnection(1, 3);

        // Displaying friends after removal
        system.displayFriends(1);
    }
}
