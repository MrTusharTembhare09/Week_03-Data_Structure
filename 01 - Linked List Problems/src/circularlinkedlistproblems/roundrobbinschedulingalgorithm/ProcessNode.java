package circularlinkedlistproblems.roundrobbinschedulingalgorithm;

// Node class representing a process in the circular linked list
class ProcessNode {
    int processID;
    int burstTime;
    int priority;
    ProcessNode next;

    // Constructor to initialize a process node
    public ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
