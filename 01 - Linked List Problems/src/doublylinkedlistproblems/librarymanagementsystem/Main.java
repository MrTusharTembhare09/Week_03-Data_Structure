package doublylinkedlistproblems.librarymanagementsystem;

// Main class to test the Library Management System
public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books
        library.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, false);
        library.addBookAtPosition("1984", "George Orwell", "Dystopian", 103, true, 2);

        // Displaying books
        library.displayBooksForward();
        library.displayBooksReverse();

        // Searching books
        library.searchBookByTitle("1984");
        library.searchBookByAuthor("Harper Lee");

        // Updating book availability
        library.updateBookAvailability(102, true);

        // Counting books
        library.countBooks();

        // Removing a book
        library.removeBookByID(103);

        // Displaying books after removal
        library.displayBooksForward();
    }
}
