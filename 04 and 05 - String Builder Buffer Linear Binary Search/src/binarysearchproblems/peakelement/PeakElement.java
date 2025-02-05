package binarysearchproblems.peakelement;

import java.util.*;

public class PeakElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of an input array : ");
        int n = input.nextInt();

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }


        // Applying the binary search algorithm
        int start = 0;
        int end = n-1;

        int mid = start + (end-start)/2;

        while(start < end){

            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }

            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }

            mid = start + (end-start)/2;
        }

        // Returning the peak element
        System.out.println("The peak element is : " + nums[start]);
    }
}
