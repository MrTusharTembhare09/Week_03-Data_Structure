package hashmapandhashfunctionproblem.subarrayswithzerosum;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

// Finding all subarrays with zero sum
class ZeroSumSubarrays {
    // Finding subarrays whose sum is zero
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>(); // List to store subarrays
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // HashMap to store cumulative sums
        int sum = 0;

        // Adding initial condition to handle subarrays starting from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Calculating cumulative sum

            // If sum is found in map, subarrays exist
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i}); // Adding subarray indices
                }
            }

            // Storing index for current sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
}
