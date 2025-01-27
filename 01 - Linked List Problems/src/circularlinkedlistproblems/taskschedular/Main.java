package circularlinkedlistproblems.taskschedular;

// Main class to test the Task Scheduler
public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addTaskAtBeginning(101, "Complete Project", 1, "2023-10-15");
        scheduler.addTaskAtEnd(102, "Write Report", 2, "2023-10-20");
        scheduler.addTaskAtPosition(103, "Review Code", 3, "2023-10-18", 2);

        // Displaying all tasks
        scheduler.displayAllTasks();

        // Searching tasks by priority
        scheduler.searchTasksByPriority(2);

        // Viewing the next task
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        // Removing a task
        scheduler.removeTaskByID(102);

        // Displaying all tasks after removal
        scheduler.displayAllTasks();
    }
}
