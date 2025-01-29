package hashmapandhashfunctionproblem.longestconsecutivesequence;

// Main class to test longest consecutive sequence
class Main {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Finding the longest consecutive sequence length
        int longestSequence = LongestConsecutiveSequence.findLongestConsecutive(nums);

        // Printing the result
        System.out.println("Longest Consecutive Sequence Length: " + longestSequence);
    }
}
