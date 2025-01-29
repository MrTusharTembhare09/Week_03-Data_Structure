package hashmapandhashfunctionproblem.pairwithgivensum;

// Main class to test finding a pair with the given sum
class Main {
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        // Checking if a pair exists with the given sum
        boolean result = PairWithGivenSum.hasPairWithSum(arr, target);

        // Printing the result
        if (result) {
            System.out.println("Pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum found.");
        }
    }
}
