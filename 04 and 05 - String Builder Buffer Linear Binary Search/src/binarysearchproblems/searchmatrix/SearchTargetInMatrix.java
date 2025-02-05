package binarysearchproblems.searchmatrix;

import java.util.*;

public class SearchTargetInMatrix {
    public static void main(String[] args) {
        // Creating an object of scanner class
        Scanner input = new Scanner(System.in);

        // Number of rows
        System.out.print("Enter number of rows : ");
        int rows = input.nextInt();

        System.out.println();

        // Number of columns
        System.out.print("Enter number of columns : ");
        int columns = input.nextInt();

        // Defining the 2D integer matrix
        int[][] nums = new int[rows][columns];

        // Getting the elements from user
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                nums[i][j] = input.nextInt();
            }
            System.out.println();
        }

        // Target element
        System.out.print("Enter the target element : ");
        int target = input.nextInt();

        // Applying the logic of binary search algorithm on 2D matrix
        int s = 0;
        int e = (rows * columns)-1;

        int result = 0;

        int mid = s + (e-s)/2;

        while(s <= e) {

            int element = nums[mid / columns][mid % columns];
            if(element == target) {
                System.out.println("Target element found");
                result = 1;
                break;
            }

            if(element < target)
                s = mid + 1;
            else
                e = mid - 1;

            mid = s + (e-s)/2;
        }

        // Checking if target element is found or not
        if(result == 0)
            System.out.println("Target element not found");
    }
}
