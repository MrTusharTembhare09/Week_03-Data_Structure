package countsortstudentage;

import java.util.Arrays;

public class CountingSortStudentAges {

    // Sorting ages using Counting Sort
    public static void countingSort(int[] ages) {
        int minAge = 10; // Minimum age
        int maxAge = 18; // Maximum age
        int range = maxAge - minAge + 1; // Range of values (10 to 18)

        // Creating a count array to store frequency of ages
        int[] count = new int[range];

        // Storing the count of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Calculating cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Creating output array to store sorted values
        int[] sortedAges = new int[ages.length];

        // Placing elements in correct position
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            sortedAges[count[age - minAge] - 1] = age;
            count[age - minAge]--; // Reducing count after placing the element
        }

        // Copying sorted values back to original array
        System.arraycopy(sortedAges, 0, ages, 0, ages.length);
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        int[] studentAges = {15, 12, 17, 14, 16, 15, 13, 18, 11, 10, 12, 14};

        System.out.println("Before Sorting: " + Arrays.toString(studentAges));

        // Sorting ages using Counting Sort
        countingSort(studentAges);

        System.out.println("After Sorting: " + Arrays.toString(studentAges));
    }
}

