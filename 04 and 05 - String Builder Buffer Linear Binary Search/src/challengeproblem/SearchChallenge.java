package challengeproblem;

import java.util.Arrays;

public class SearchChallenge {

    // Searching the first missing positive integer using Linear Search
    public static int findMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1];

        // Marking numbers present in the array
        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Finding the first missing positive integer
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1;
    }

    // Searching the target index using Binary Search
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Returning the index if found
            } else if (nums[mid] < target) {
                left = mid + 1; // Searching in the right half
            } else {
                right = mid - 1; // Searching in the left half
            }
        }

        return -1; // Returning -1 if target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        // Finding the first missing positive integer
        int missing = findMissingPositive(nums);
        System.out.println("First missing positive integer: " + missing);

        // Sorting the array before performing Binary Search
        Arrays.sort(nums);
        int target = 3;
        int index = binarySearch(nums, target);
        System.out.println("Index of target (" + target + "): " + index);
    }
}

