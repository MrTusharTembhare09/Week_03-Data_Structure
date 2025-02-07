package fibonacci;

public class FibonacciComparison {

    // Recursive Fibonacci (Exponential Time Complexity: O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time Complexity: O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; // Fibonacci number to compute

        // Measure execution time for Recursive Fibonacci
        long startTime = System.nanoTime();
        int fibRec = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        System.out.println("Recursive Fibonacci of " + n + ": " + fibRec);
        System.out.println("Recursive Execution Time: " + (endTime - startTime) / 1e6 + " ms");

        // Measure execution time for Iterative Fibonacci
        startTime = System.nanoTime();
        int fibIter = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("Iterative Fibonacci of " + n + ": " + fibIter);
        System.out.println("Iterative Execution Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}

