package singlylinkedlistproblems.socialmediafriendconnectionssystem;

// Node class representing a friend ID in the nested linked list
class FriendNode {
    int friendID;
    FriendNode next;

    // Constructor to initialize a friend node
    public FriendNode(int friendID) {
        this.friendID = friendID;
        this.next = null;
    }
}
