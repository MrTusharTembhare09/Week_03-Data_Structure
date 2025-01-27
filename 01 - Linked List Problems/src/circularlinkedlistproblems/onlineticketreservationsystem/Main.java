package circularlinkedlistproblems.onlineticketreservationsystem;

// Main class to test the Online Ticket Reservation System
public class Main {
    public static void main(String[] args) {
        TicketReservationSystem reservationSystem = new TicketReservationSystem();

        // Adding tickets to the system
        reservationSystem.addTicket(101, "Alice", "Avengers", "A1", "2025-01-28 14:00");
        reservationSystem.addTicket(102, "Bob", "Batman", "B2", "2025-01-28 15:30");
        reservationSystem.addTicket(103, "Charlie", "Avengers", "C3", "2025-01-28 17:00");

        // Displaying all booked tickets
        reservationSystem.displayTickets();

        // Searching for a ticket by customer name
        reservationSystem.searchTicket("Alice");

        // Searching for a ticket by movie name
        reservationSystem.searchTicket("Avengers");

        // Removing a ticket by ticket ID
        reservationSystem.removeTicket(102);

        // Displaying tickets after removal
        reservationSystem.displayTickets();

        // Displaying total number of booked tickets
        reservationSystem.totalBookedTickets();
    }
}
