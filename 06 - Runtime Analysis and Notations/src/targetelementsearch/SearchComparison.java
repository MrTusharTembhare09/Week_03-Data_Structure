package targetelementsearch;

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Performing Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Returning the index if found
            }
        }
        return -1; // Returning -1 if not found
    }

    // Performing Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Returning the index if found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Returning -1 if not found
    }

    // Generating random dataset
    public static int[] generateDataset(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10); // Generating random numbers
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Different dataset sizes
        int target = 500; // Sample target value

        for (int size : sizes) {
            int[] dataset = generateDataset(size);

            // Measuring Linear Search time
            long startTime = System.nanoTime();
            linearSearch(dataset, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            // Sorting for Binary Search
            Arrays.sort(dataset);

            // Measuring Binary Search time
            startTime = System.nanoTime();
            binarySearch(dataset, target);
            endTime = System.nanoTime();
            long binaryTime = endTime - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1e6 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1e6 + " ms");
            System.out.println("--------------------------------");
        }
    }
}
