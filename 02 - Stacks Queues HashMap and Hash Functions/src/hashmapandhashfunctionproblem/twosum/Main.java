package hashmapandhashfunctionproblem.twosum;

// Main class to test Two Sum Problem
class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Finding two sum indices
        int[] result = TwoSum.findTwoSum(nums, target);

        // Printing the result
        if (result.length > 0) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found with the given sum.");
        }
    }
}
