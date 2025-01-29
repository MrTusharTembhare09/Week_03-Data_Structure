package stackandqueuesampleproblem.implementaqueueusingstack;

import java.util.Stack;

public class QueueUsingStacks {
    // Stack for enqueuing elements
    private Stack<Integer> stack1;
    // Stack for dequeuing elements
    private Stack<Integer> stack2;

    // Initializing the queue
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Adding an element to the queue
    public void enqueue(int data) {
        // Pushing element into stack1
        stack1.push(data);
    }

    // Removing an element from the queue
    public int dequeue() {
        // Checking if stack2 is empty
        if (stack2.isEmpty()) {
            // Checking if both stacks are empty
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            // Transferring elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Popping element from stack2
        return stack2.pop();
    }

    // Checking if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Getting the front element of the queue without removing it
    public int peek() {
        if (stack2.isEmpty()) { // Checking if stack2 is empty
            if (stack1.isEmpty()) { // Checking if both stacks are empty
                throw new RuntimeException("Queue is empty");
            }
            // Transferring elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek(); // Peeking element from stack2
    }
}
