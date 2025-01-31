package mergesortbookprice;

public class Merge {
    public static void merge(int bookprices[], int left, int mid, int right) {
        // Calculating the sizes of the two subarrays to be merged
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // Creating temporary arrays to store left and right subarrays
        int leftArr[] = new int[len1];
        int rightArr[] = new int[len2];

        // Copying data from the original array to the left and right subarrays
        System.arraycopy(bookprices, left, leftArr, 0, len1);
        System.arraycopy(bookprices, mid + 1, rightArr, 0, len2);

        // Merging the two sorted subarrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            // Comparing elements from both subarrays and insert the smaller one
            if (leftArr[i] <= rightArr[j]) {
                bookprices[k++] = leftArr[i++];
            } else {
                bookprices[k++] = rightArr[j++];
            }
        }

        // Copying any remaining elements from the left subarray
        while (i < len1) bookprices[k++] = leftArr[i++];

        // Copying any remaining elements from the right subarray
        while (j < len2) bookprices[k++] = rightArr[j++];
    }
}

