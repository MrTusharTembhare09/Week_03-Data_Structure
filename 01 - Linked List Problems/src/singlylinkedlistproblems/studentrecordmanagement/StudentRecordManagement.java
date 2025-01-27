package singlylinkedlistproblems.studentrecordmanagement;

// Main class to test the program
public class StudentRecordManagement {
    public static void main(String[] args) {
        SinglyLinkedList studentList = new SinglyLinkedList();

        // Adding student records
        studentList.addAtBeginning(101, "Alice", 20, 'A');
        studentList.addAtEnd(102, "Bob", 22, 'B');
        studentList.addAtPosition(2, 103, "Charlie", 21, 'C');

        // Displaying all records
        studentList.displayAllRecords();

        // Searching for a student record
        studentList.searchByRollNumber(102);

        // Updating a student's grade
        studentList.updateGradeByRollNumber(103, 'A');

        // Deleting a student record
        studentList.deleteByRollNumber(101);

        // Displaying all records again
        studentList.displayAllRecords();
    }
}
