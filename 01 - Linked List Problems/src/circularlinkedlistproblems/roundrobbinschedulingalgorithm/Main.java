package circularlinkedlistproblems.roundrobbinschedulingalgorithm;

// Main class to test the Round Robin Scheduler
public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4); // Set time quantum to 4

        // Adding processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        // Displaying processes
        scheduler.displayProcesses();

        // Simulating scheduling
        scheduler.simulateScheduling();
    }
}
