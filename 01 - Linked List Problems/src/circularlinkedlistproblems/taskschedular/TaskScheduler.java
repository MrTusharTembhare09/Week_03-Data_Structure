package circularlinkedlistproblems.taskschedular;

// Circular Linked List class for managing tasks
class TaskScheduler {
    private TaskNode head;
    private TaskNode currentTask; // Pointer to the current task

    // Constructor to initialize an empty list
    public TaskScheduler() {
        this.head = null;
        this.currentTask = null;
    }

    // Adding a task at the beginning of the list
    public void addTaskAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself to create a circular list
        } else {
            TaskNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            head = newNode;
            last.next = head; // Maintain circularity
        }
        System.out.println("Adding task at the beginning: " + taskName);
    }

    // Adding a task at the end of the list
    public void addTaskAtEnd(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself to create a circular list
        } else {
            TaskNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head; // Maintain circularity
        }
        System.out.println("Adding task at the end: " + taskName);
    }

    // Adding a task at a specific position in the list
    public void addTaskAtPosition(int taskID, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be greater than 0.");
            return;
        }
        if (position == 1) {
            addTaskAtBeginning(taskID, taskName, priority, dueDate); // Add at the beginning if position is 1
            return;
        }
        TaskNode newNode = new TaskNode(taskID, taskName, priority, dueDate);
        TaskNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
            if (current.next == head) {
                break; // Stop if we loop back to the head
            }
        }
        if (current == null || current.next == head) {
            System.out.println("Position exceeds the length of the list.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Adding task at position " + position + ": " + taskName);
    }

    // Removing a task by its Task ID
    public void removeTaskByID(int taskID) {
        if (head == null) {
            System.out.println("List is empty. No task to remove.");
            return;
        }
        TaskNode current = head;
        TaskNode prev = null;
        do {
            if (current.taskID == taskID) {
                if (prev == null) {
                    // If the task to be removed is the head
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head == head.next) {
                        head = null; // If only one node exists
                    } else {
                        head = head.next;
                        last.next = head; // Maintain circularity
                    }
                } else {
                    prev.next = current.next; // Remove the node
                }
                System.out.println("Removing task with ID: " + taskID);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task not found with ID: " + taskID);
    }

    // Viewing the current task and moving to the next task
    public void viewNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        if (currentTask == null) {
            currentTask = head; // Start from the head if no current task is set
        }
        System.out.println("Current Task: " + currentTask.taskName + " (ID: " + currentTask.taskID + ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate + ")");
        currentTask = currentTask.next; // Move to the next task
    }

    // Displaying all tasks in the list starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        System.out.println("Displaying all tasks:");
        do {
            System.out.println(current.taskName + " (ID: " + current.taskID + ", Priority: " + current.priority + ", Due Date: " + current.dueDate + ")");
            current = current.next;
        } while (current != head);
    }

    // Searching for tasks by Priority
    public void searchTasksByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        System.out.println("Searching for tasks with priority: " + priority);
        do {
            if (current.priority == priority) {
                System.out.println("Found: " + current.taskName + " (ID: " + current.taskID + ", Due Date: " + current.dueDate + ")");
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}
