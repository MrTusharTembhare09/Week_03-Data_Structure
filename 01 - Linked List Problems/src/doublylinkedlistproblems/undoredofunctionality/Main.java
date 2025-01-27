package doublylinkedlistproblems.undoredofunctionality;

// Main class to test the Undo/Redo System
public class Main {
    public static void main(String[] args) {
        UndoRedoSystem editor = new UndoRedoSystem(10); // Set maximum history size to 10

        // Adding text states
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.addTextState("Hello World!");

        // Displaying the current state
        editor.displayCurrentState();

        // Performing undo
        editor.undo();
        editor.displayCurrentState();

        // Performing redo
        editor.redo();
        editor.displayCurrentState();

        // Adding more text states
        editor.addTextState("Hello World! How are you?");
        editor.addTextState("Hello World! How are you doing?");

        // Displaying the current state
        editor.displayCurrentState();

        // Performing undo twice
        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        // Performing redo
        editor.redo();
        editor.displayCurrentState();
    }
}
