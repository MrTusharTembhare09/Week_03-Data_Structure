package stackandqueuesampleproblem.stockspanproblem;

import java.util.Stack;

// Solving Stock Span Problem using Stack
class StockSpan {
    // Calculating stock span for each day
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Array to store span values
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // Removing elements from stack while stack is not empty and price at top index is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous prices are smaller, so span is i+1
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Pushing current index onto stack
            stack.push(i);
        }
        return span;
    }
}
