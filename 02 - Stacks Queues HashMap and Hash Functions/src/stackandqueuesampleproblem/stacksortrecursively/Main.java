package stackandqueuesampleproblem.stacksortrecursively;

import java.util.Stack;

// Main class to test the sorting of stack
class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Adding elements to the stack
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack: " + stack);

        // Sorting the stack
        SortStackRecursively.sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
