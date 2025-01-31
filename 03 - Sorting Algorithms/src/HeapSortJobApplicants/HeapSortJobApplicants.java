package HeapSortJobApplicants;

import java.util.Arrays;

public class HeapSortJobApplicants {

    // Sorting salaries using Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Building a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extracting elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swapping the root (largest) with the last element
            swap(salaries, 0, i);

            // Reheapifying the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapifying a subtree with root at index i
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i;         // Initializing largest as root
        int left = 2 * i + 1;    // Left child index
        int right = 2 * i + 2;   // Right child index

        // Checking if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Checking if right child is larger than the largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // Swapping and recursively heapifying if needed
        if (largest != i) {
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }

    // Swapping two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        int[] salaries = {50000, 75000, 60000, 90000, 45000, 80000};

        System.out.println("Before Sorting: " + Arrays.toString(salaries));

        // Sorting the salaries using Heap Sort
        heapSort(salaries);

        System.out.println("After Sorting: " + Arrays.toString(salaries));
    }
}

