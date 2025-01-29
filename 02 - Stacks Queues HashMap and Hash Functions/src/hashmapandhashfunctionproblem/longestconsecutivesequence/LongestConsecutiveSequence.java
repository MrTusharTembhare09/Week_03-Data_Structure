package hashmapandhashfunctionproblem.longestconsecutivesequence;

import java.util.HashSet;

// Finding the length of the longest consecutive sequence in an array
class LongestConsecutiveSequence {
    // Finding the longest consecutive sequence length
    public static int findLongestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // HashSet to store unique elements

        // Adding all elements to the set
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Iterating through each element
        for (int num : nums) {
            // Checking if it is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Checking for consecutive elements
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Updating the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}