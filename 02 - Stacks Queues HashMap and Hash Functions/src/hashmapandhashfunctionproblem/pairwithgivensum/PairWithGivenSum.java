package hashmapandhashfunctionproblem.pairwithgivensum;

import java.util.HashSet;

// Checking for a pair with given sum in an array
class PairWithGivenSum {
    // Finding if a pair exists with the given target sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>(); // HashSet to store visited numbers

        for (int num : arr) {
            // Checking if target - current number exists in the set
            if (set.contains(target - num)) {
                return true; // Pair found
            }
            // Adding current number to the set
            set.add(num);
        }
        return false; // No pair found
    }
}
