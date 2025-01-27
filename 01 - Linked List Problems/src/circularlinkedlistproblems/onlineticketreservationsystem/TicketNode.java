package circularlinkedlistproblems.onlineticketreservationsystem;

// Node class representing a booked ticket
class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next; // Pointer to the next node in the circular linked list

    // Constructor to initialize a ticket node
    public TicketNode(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
