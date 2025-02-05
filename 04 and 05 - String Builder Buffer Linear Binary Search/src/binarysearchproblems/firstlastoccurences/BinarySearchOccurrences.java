package binarysearchproblems.firstlastoccurences;

public class BinarySearchOccurrences {

    // Finding the first occurrence of a target using Binary Search
    public static int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid; // Storing the first occurrence index
                right = mid - 1; // Searching further left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    // Finding the last occurrence of a target using Binary Search
    public static int findLastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid; // Storing the last occurrence index
                left = mid + 1; // Searching further right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        // Finding first and last occurrences of a target
        int firstIndex = findFirstOccurrence(nums, target);
        int lastIndex = findLastOccurrence(nums, target);

        System.out.println("First occurrence of " + target + ": " + firstIndex);
        System.out.println("Last occurrence of " + target + ": " + lastIndex);
    }
}

