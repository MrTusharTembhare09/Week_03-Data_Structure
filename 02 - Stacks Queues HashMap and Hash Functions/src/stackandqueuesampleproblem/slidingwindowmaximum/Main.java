package stackandqueuesampleproblem.slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

// Main class to test Sliding Window Maximum
class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Calculating sliding window maximums
        int[] result = SlidingWindowMaximum.maxSlidingWindow(nums, k);

        // Printing the result
        System.out.println("Sliding Window Maximums: " + Arrays.toString(result));
    }
}
