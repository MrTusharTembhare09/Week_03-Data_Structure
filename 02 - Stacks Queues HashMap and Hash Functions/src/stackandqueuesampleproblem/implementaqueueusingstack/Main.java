package stackandqueuesampleproblem.implementaqueueusingstack;

public class Main {
    public static void main(String[] args) {
        // Creating a queue object
        QueueUsingStacks queue = new QueueUsingStacks();

        // Inserting the elements in the queue

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);


        // Deleting the queue element
        queue.dequeue();

        // If empty or not
        boolean result = queue.isEmpty();

        // fetching the peek element
        int top = queue.peek();
        System.out.println("Top element is : " + top);
    }
}
