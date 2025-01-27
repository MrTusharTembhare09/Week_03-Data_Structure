package circularlinkedlistproblems.roundrobbinschedulingalgorithm;

// Circular Linked List class for managing processes
class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private int timeQuantum; // Fixed time quantum for each process

    // Constructor to initialize the scheduler with a time quantum
    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    // Adding a new process at the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processID, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            head.next = head; // Point to itself to create a circular list
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode; // Update tail to the new node
        }
        System.out.println("Adding process: " + processID);
    }

    // Removing a process by its Process ID after its execution
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        ProcessNode current = head;
        ProcessNode prev = null;
        do {
            if (current.processID == processID) {
                if (prev == null) {
                    // If the process to be removed is the head
                    if (head == head.next) {
                        head = null; // If only one node exists
                    } else {
                        head = head.next;
                        tail.next = head; // Maintain circularity
                    }
                } else {
                    prev.next = current.next; // Remove the node
                }
                System.out.println("Removing process with ID: " + processID);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Process not found with ID: " + processID);
    }

    // Simulating the scheduling of processes in a round-robin manner
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes available for scheduling.");
            return;
        }
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int totalProcesses = 0;
        ProcessNode current = head;
        System.out.println("Starting Round Robin Scheduling with time quantum: " + timeQuantum);
        do {
            System.out.println("Executing Process: " + current.processID + " (Burst Time: " + current.burstTime + ")");
            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum; // Reduce burst time by time quantum
                totalWaitingTime += timeQuantum;
                totalTurnAroundTime += timeQuantum;
            } else {
                totalWaitingTime += current.burstTime;
                totalTurnAroundTime += current.burstTime;
                System.out.println("Process " + current.processID + " completed.");
                removeProcess(current.processID); // Remove the process after completion
            }
            current = current.next; // Move to the next process
            totalProcesses++;
        } while (head != null); // Continue until all processes are completed
        System.out.println("Scheduling completed.");
        double averageWaitingTime = (double) totalWaitingTime / totalProcesses;
        double averageTurnAroundTime = (double) totalTurnAroundTime / totalProcesses;
        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turn-Around Time: " + averageTurnAroundTime);
    }

    // Displaying the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        ProcessNode current = head;
        System.out.println("Displaying processes in the circular queue:");
        do {
            System.out.println("Process: " + current.processID + " (Burst Time: " + current.burstTime + ", Priority: " + current.priority + ")");
            current = current.next;
        } while (current != head);
    }
}
