package doublylinkedlistproblems.undoredofunctionality;

// Node class representing a state of the text content
class TextStateNode {
    String text;
    TextStateNode prev;
    TextStateNode next;

    // Constructor to initialize a text state node
    public TextStateNode(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}
