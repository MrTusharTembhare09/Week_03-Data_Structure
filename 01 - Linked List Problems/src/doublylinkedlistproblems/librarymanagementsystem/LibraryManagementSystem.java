package doublylinkedlistproblems.librarymanagementsystem;

// Doubly Linked List class for managing books
class LibraryManagementSystem {
    private BookNode head;
    private BookNode tail;

    // Constructor to initialize an empty list
    public LibraryManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    // Adding a book at the beginning of the list
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newNode; // If list is empty, set head and tail to the new node
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode; // Update head to the new node
        }
        System.out.println("Adding book at the beginning: " + title);
    }

    // Adding a book at the end of the list
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newNode; // If list is empty, set head and tail to the new node
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Update tail to the new node
        }
        System.out.println("Adding book at the end: " + title);
    }

    // Adding a book at a specific position in the list
    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be greater than 0.");
            return;
        }
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookID, isAvailable); // Add at the beginning if position is 1
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookID, isAvailable);
        BookNode current = head;
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
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode; // Update tail if adding at the end
        }
        current.next = newNode;
        newNode.prev = current;
        System.out.println("Adding book at position " + position + ": " + title);
    }

    // Removing a book by its Book ID
    public void removeBookByID(int bookID) {
        if (head == null) {
            System.out.println("Library is empty. No book to remove.");
            return;
        }
        BookNode current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Update head if removing the first node
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Update tail if removing the last node
                }
                System.out.println("Removing book with ID: " + bookID);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found with ID: " + bookID);
    }

    // Searching for a book by its Title
    public void searchBookByTitle(String title) {
        BookNode current = head;
        boolean found = false;
        System.out.println("Searching for book with title: " + title);
        while (current != null) {
            if (current.title.equals(title)) {
                System.out.println("Found: " + current.title + " by " + current.author + " (ID: " + current.bookID + ", Genre: " + current.genre + ", Available: " + current.isAvailable + ")");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Book not found with title: " + title);
        }
    }

    // Searching for a book by its Author
    public void searchBookByAuthor(String author) {
        BookNode current = head;
        boolean found = false;
        System.out.println("Searching for books by author: " + author);
        while (current != null) {
            if (current.author.equals(author)) {
                System.out.println("Found: " + current.title + " by " + current.author + " (ID: " + current.bookID + ", Genre: " + current.genre + ", Available: " + current.isAvailable + ")");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    // Updating a book's availability status by its Book ID
    public void updateBookAvailability(int bookID, boolean isAvailable) {
        BookNode current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                System.out.println("Updating availability of book with ID " + bookID + " to " + isAvailable);
                current.isAvailable = isAvailable;
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found with ID: " + bookID);
    }

    // Displaying all books in forward order
    public void displayBooksForward() {
        BookNode current = head;
        System.out.println("Displaying books in forward order:");
        while (current != null) {
            System.out.println(current.title + " by " + current.author + " (ID: " + current.bookID + ", Genre: " + current.genre + ", Available: " + current.isAvailable + ")");
            current = current.next;
        }
    }

    // Displaying all books in reverse order
    public void displayBooksReverse() {
        BookNode current = tail;
        System.out.println("Displaying books in reverse order:");
        while (current != null) {
            System.out.println(current.title + " by " + current.author + " (ID: " + current.bookID + ", Genre: " + current.genre + ", Available: " + current.isAvailable + ")");
            current = current.prev;
        }
    }

    // Counting the total number of books in the library
    public void countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books in the library: " + count);
    }
}
