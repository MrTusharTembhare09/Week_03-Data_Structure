package circularlinkedlistproblems.onlineticketreservationsystem;

// Circular Linked List class for managing ticket reservations
class TicketReservationSystem {
    private TicketNode head;
    private TicketNode tail;

    // Constructor to initialize the reservation system
    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            head.next = head; // Point to itself to create a circular list
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket; // Update tail to the new ticket
        }
        System.out.println("Ticket booked for Customer: " + customerName + ", Movie: " + movieName);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        TicketNode current = head;
        TicketNode prev = null;
        do {
            if (current.ticketID == ticketID) {
                if (prev == null) {
                    // If the ticket to be removed is the head
                    if (head == head.next) {
                        head = null; // If only one node exists
                    } else {
                        head = head.next;
                        tail.next = head; // Maintain circularity
                    }
                } else {
                    prev.next = current.next; // Remove the ticket node
                }
                System.out.println("Ticket removed for Ticket ID: " + ticketID);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket not found with Ticket ID: " + ticketID);
    }

    // Displaying the current tickets in the circular list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        TicketNode current = head;
        System.out.println("Displaying booked tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName
                    + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket found: Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName
                        + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No ticket found with the search term: " + searchTerm);
        }
    }

    // Calculate the total number of booked tickets
    public void totalBookedTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        int count = 0;
        TicketNode current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        System.out.println("Total booked tickets: " + count);
    }
}