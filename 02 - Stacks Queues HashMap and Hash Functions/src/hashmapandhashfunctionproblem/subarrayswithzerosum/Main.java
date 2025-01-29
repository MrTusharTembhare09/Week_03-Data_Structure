package hashmapandhashfunctionproblem.subarrayswithzerosum;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

// Main class to test finding zero-sum subarrays
class Main {
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        // Finding zero-sum subarrays
        List<int[]> subarrays = ZeroSumSubarrays.findZeroSumSubarrays(arr);

        // Printing the result
        System.out.println("Zero Sum Subarrays: ");
        for (int[] subarray : subarrays) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}
