package quicksortproductprices;

import java.util.Arrays;

public class QuickSort {

    // Sorting product prices using Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Finding the partition index
            int partitionIndex = partition(prices, low, high);

            // Recursively sorting the left and right parts
            quickSort(prices, low, partitionIndex - 1);
            quickSort(prices, partitionIndex + 1, high);
        }
    }

    // Partitioning the array around the pivot
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing pivot (last element)
        int i = low - 1; // Tracking smaller element position

        for (int j = low; j < high; j++) {
            // Checking if current element is smaller than pivot
            if (prices[j] < pivot) {
                i++; // Moving the partition index
                swap(prices, i, j); // Swapping elements
            }
        }
        swap(prices, i + 1, high); // Swapping pivot into correct position
        return i + 1; // Returning partition index
    }

    // Swapping two elements in the array
    private static void swap(int[] prices, int i, int j) {
        int temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

    public static void main(String[] args) {
        // Adding product prices
        int[] productPrices = {199, 99, 299, 149, 349, 50};

        // Printing original product prices
        System.out.println("Original Prices: " + Arrays.toString(productPrices));

        // Sorting the product prices
        quickSort(productPrices, 0, productPrices.length - 1);

        // Printing sorted product prices
        System.out.println("Sorted Prices: " + Arrays.toString(productPrices));
    }
}

