package stackandqueuesampleproblem.slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

// Solving Sliding Window Maximum using Deque
class SlidingWindowMaximum {
    // Finding maximum in each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store maximums
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices

        for (int i = 0; i < n; i++) {
            // Removing elements out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Removing elements smaller than the current element from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Adding current element index to the deque
            deque.offerLast(i);

            // Adding the maximum element of the window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}