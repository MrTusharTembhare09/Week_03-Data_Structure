package singlylinkedlistproblems.studentrecordmanagement;

// Node class representing a student record
class Node {
    int rollNumber;
    String name;
    int age;
    char grade;
    Node next; // Pointer to the next node

    // Constructor to initialize a node
    public Node(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null; // Initialize next to null
    }
}
