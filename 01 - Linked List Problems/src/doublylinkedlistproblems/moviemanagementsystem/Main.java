package doublylinkedlistproblems.moviemanagementsystem;

// Main class to test the Movie Management System
public class Main {
    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        // Adding movies
        system.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        system.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        system.addMovieAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 2);

        // Displaying movies
        system.displayMoviesForward();
        system.displayMoviesReverse();

        // Searching movies
        system.searchMoviesByDirector("Christopher Nolan");
        system.searchMoviesByRating(8.8);

        // Updating a movie's rating
        system.updateMovieRating("Inception", 9.2);

        // Removing a movie
        system.removeMovieByTitle("Interstellar");

        // Displaying movies after removal
        system.displayMoviesForward();
    }
}
