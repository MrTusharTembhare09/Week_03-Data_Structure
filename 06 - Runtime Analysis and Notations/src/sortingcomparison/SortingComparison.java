package sortingcomparison;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Performing Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Performing Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Performing Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Generating random dataset
    public static int[] generateDataset(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000}; // Different dataset sizes

        for (int size : sizes) {
            int[] dataset = generateDataset(size);
            int[] copy1 = Arrays.copyOf(dataset, dataset.length);
            int[] copy2 = Arrays.copyOf(dataset, dataset.length);
            int[] copy3 = Arrays.copyOf(dataset, dataset.length);

            // Measuring Bubble Sort time
            long startTime = System.nanoTime();
            bubbleSort(copy1);
            long endTime = System.nanoTime();
            long bubbleTime = endTime - startTime;

            // Measuring Merge Sort time
            startTime = System.nanoTime();
            mergeSort(copy2, 0, copy2.length - 1);
            endTime = System.nanoTime();
            long mergeTime = endTime - startTime;

            // Measuring Quick Sort time
            startTime = System.nanoTime();
            quickSort(copy3, 0, copy3.length - 1);
            endTime = System.nanoTime();
            long quickTime = endTime - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time: " + bubbleTime / 1e6 + " ms");
            System.out.println("Merge Sort Time: " + mergeTime / 1e6 + " ms");
            System.out.println("Quick Sort Time: " + quickTime / 1e6 + " ms");
            System.out.println("--------------------------------");
        }
    }
}

