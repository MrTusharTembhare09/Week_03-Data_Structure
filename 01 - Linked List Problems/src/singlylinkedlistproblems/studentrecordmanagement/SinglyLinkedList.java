package singlylinkedlistproblems.studentrecordmanagement;

// Singly linked list class for managing student records
class SinglyLinkedList {
    private Node head; // Head of the list

    // Adding a new student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head; // Point new node to the current head
        head = newNode; // Update head to the new node
    }

    // Adding a new student at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) { // If the list is empty
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) { // Traverse to the last node
            current = current.next;
        }
        current.next = newNode; // Add new node at the end
    }

    // Adding a new student at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNumber, name, age, grade);
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) { // Traverse to the position
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = current.next; // Update links for insertion
        current.next = newNode;
    }

    // Deleting a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) { // If the head node is to be deleted
            head = head.next;
            System.out.println("Record with Roll Number " + rollNumber + " deleted.");
            return;
        }
        Node current = head, previous = null;
        while (current != null && current.rollNumber != rollNumber) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Record not found.");
            return;
        }
        previous.next = current.next; // Update links to delete node
        System.out.println("Record with Roll Number " + rollNumber + " deleted.");
    }

    // Searching for a student record by Roll Number
    public void searchByRollNumber(int rollNumber) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Record Found:");
                System.out.println("Roll Number: " + current.rollNumber);
                System.out.println("Name: " + current.name);
                System.out.println("Age: " + current.age);
                System.out.println("Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
    }

    // Updating a student's grade by Roll Number
    public void updateGradeByRollNumber(int rollNumber, char newGrade) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber);
                return;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
    }

    // Displaying all student records
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}
