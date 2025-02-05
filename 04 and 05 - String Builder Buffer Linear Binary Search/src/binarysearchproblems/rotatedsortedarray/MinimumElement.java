package binarysearchproblems.rotatedsortedarray;

import java.util.*;

public class MinimumElement {
    public static void main(String[] args) {
        // Using scanner class
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of input array : ");
        int n = input.nextInt();

        // Specifying an input array
        int[] nums = new int[n];

        // Getting an elements from the user
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }


        // Applying the binary search algorithm logic (TC - log n)
        int start = 0;
        int end = n-1;

        int mid = start + (end-start)/2;

        while(start < end) {
            if(nums[mid] >= nums[end])
                start = mid+1;
            else
                end = mid;

            mid = start + (end-start)/2;
        }

        // Printing the rotation point
        System.out.println("The rotation point is : " + nums[start]);
    }
}
