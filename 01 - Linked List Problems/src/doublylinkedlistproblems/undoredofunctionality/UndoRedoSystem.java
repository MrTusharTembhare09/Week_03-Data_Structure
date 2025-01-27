package doublylinkedlistproblems.undoredofunctionality;

// Doubly Linked List class for managing text states
class UndoRedoSystem {
    private TextStateNode head;
    private TextStateNode tail;
    private TextStateNode currentState; // Pointer to the current state
    private int maxHistorySize; // Maximum number of states to store
    private int currentHistorySize; // Current number of states stored

    // Constructor to initialize the system with a maximum history size
    public UndoRedoSystem(int maxHistorySize) {
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.maxHistorySize = maxHistorySize;
        this.currentHistorySize = 0;
    }

    // Adding a new text state at the end of the list
    public void addTextState(String text) {
        TextStateNode newNode = new TextStateNode(text);
        if (head == null) {
            head = tail = newNode; // If list is empty, set head and tail to the new node
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Update tail to the new node
        }
        currentState = newNode; // Update the current state to the new node
        currentHistorySize++;

        // If history exceeds the maximum size, remove the oldest state
        if (currentHistorySize > maxHistorySize) {
            head = head.next;
            head.prev = null;
            currentHistorySize--;
        }
        System.out.println("Adding new text state: " + text);
    }

    // Implementing the undo functionality (revert to the previous state)
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No previous state to undo.");
            return;
        }
        currentState = currentState.prev; // Move to the previous state
        System.out.println("Undo: Reverted to state - " + currentState.text);
    }

    // Implementing the redo functionality (revert back to the next state after undo)
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No next state to redo.");
            return;
        }
        currentState = currentState.next; // Move to the next state
        System.out.println("Redo: Reverted to state - " + currentState.text);
    }

    // Displaying the current state of the text
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No text state available.");
        } else {
            System.out.println("Current text state: " + currentState.text);
        }
    }
}
