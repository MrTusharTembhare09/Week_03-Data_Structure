package doublylinkedlistproblems.moviemanagementsystem;

// Doubly Linked List class for managing movies
class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    // Constructor to initialize an empty list
    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    // Adding a movie at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode; // If list is empty, set head and tail to the new node
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode; // Update head to the new node
        }
        System.out.println("Adding movie at the beginning: " + title);
    }

    // Adding a movie at the end of the list
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode; // If list is empty, set head and tail to the new node
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Update tail to the new node
        }
        System.out.println("Adding movie at the end: " + title);
    }

    // Adding a movie at a specific position in the list
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be greater than 0.");
            return;
        }
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating); // Add at the beginning if position is 1
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
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
        System.out.println("Adding movie at position " + position + ": " + title);
    }

    // Removing a movie by its title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty. No movie to remove.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
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
                System.out.println("Removing movie: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found with title: " + title);
    }

    // Searching for movies by director
    public void searchMoviesByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        System.out.println("Searching for movies by director: " + director);
        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("Found: " + current.title + " (" + current.year + ") - Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Searching for movies by rating
    public void searchMoviesByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        System.out.println("Searching for movies with rating: " + rating);
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Found: " + current.title + " (" + current.year + ") - Director: " + current.director);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Displaying all movies in forward order
    public void displayMoviesForward() {
        MovieNode current = head;
        System.out.println("Displaying movies in forward order:");
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Director: " + current.director + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Displaying all movies in reverse order
    public void displayMoviesReverse() {
        MovieNode current = tail;
        System.out.println("Displaying movies in reverse order:");
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Director: " + current.director + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Updating a movie's rating by its title
    public void updateMovieRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                System.out.println("Updating rating of movie: " + title + " from " + current.rating + " to " + newRating);
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found with title: " + title);
    }
}
