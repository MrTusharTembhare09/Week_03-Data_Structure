package stackandqueuesampleproblem.stacksortrecursively;

import java.util.Stack;

// Sorting a stack using recursion
class SortStackRecursively {
    // Sorting the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) { // Checking if stack is not empty
            int temp = stack.pop(); // Removing top element
            sortStack(stack); // Sorting the remaining stack
            insertSorted(stack, temp); // Inserting the element at correct position
        }
    }

    // Inserting an element into the sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) { // Checking correct position
            stack.push(element); // Pushing element to stack
        } else {
            int temp = stack.pop(); // Removing top element
            insertSorted(stack, element); // Recursively inserting in sorted order
            stack.push(temp); // Pushing the removed element back
        }
    }
}
