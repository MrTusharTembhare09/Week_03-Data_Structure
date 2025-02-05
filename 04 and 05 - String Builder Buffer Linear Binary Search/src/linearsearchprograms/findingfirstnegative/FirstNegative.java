package linearsearchprograms.findingfirstnegative;

public class FirstNegative {
    public static void main(String[] args) {
        // Defining the array with elements
        int nums[] = {34, 67, 23, -22, 10};

        // Storing the length of an array
        int n = nums.length;


        int result = -1;

        // Iterating through the given array
        for(int i = 0; i < n; i++) {
            // If I will get first negative element, I will break the iteration.
            if(nums[i] < 0) {
                result = i;
                break;
            }
        }

        // Printing the output
        if(result == -1)
            System.out.println("No negative element is present in the given array");
        else
            System.out.println("The first negative element is present at an index number : " + result);
    }
}
