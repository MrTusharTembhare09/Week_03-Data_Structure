package datastructuresearchcomparison;

import java.util.*;

public class DataStructureSearchComparison {

    // Linear Search in an Array (Time Complexity: O(N))
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 1000000; // Define dataset size
        int target = size - 1; // Element to search for
        Random random = new Random();

        // Generate dataset
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int value = random.nextInt(size * 2); // Random values to avoid duplicates in TreeSet
            array[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }

        // Measure execution time for Linear Search in Array
        long startTime = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long endTime = System.nanoTime();
        System.out.println("Array Search (O(N)): " + (endTime - startTime) / 1e6 + " ms");

        // Measure execution time for HashSet Search (O(1))
        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("HashSet Search (O(1)): " + (endTime - startTime) / 1e6 + " ms");

        // Measure execution time for TreeSet Search (O(log N))
        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search (O(log N)): " + (endTime - startTime) / 1e6 + " ms");
    }
}

