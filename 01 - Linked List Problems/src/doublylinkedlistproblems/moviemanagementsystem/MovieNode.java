package doublylinkedlistproblems.moviemanagementsystem;

// Node class representing a movie in the doubly linked list
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev;
    MovieNode next;

    // Constructor to initialize a movie node
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}
