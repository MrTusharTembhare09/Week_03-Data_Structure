package hashmapandhashfunctionproblem.twosum;

import java.util.HashMap;

// Solving Two Sum Problem using Hash Map
class TwoSum {
    // Finding indices of two numbers that add up to the target sum
    public static int[] findTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // HashMap to store indices of numbers

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Finding the complement

            // Checking if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Returning indices
            }

            // Storing the current number's index
            map.put(nums[i], i);
        }
        return new int[]{}; // Returning empty array if no pair found
    }
}
