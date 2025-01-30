package bubblesortstudentmarks;

public class BubbleSort {
    public static void sorting(int marks[]) {
        // Taking the length
        int n = marks.length;

        // Flag tracker
        boolean flag = false;

        // For loop for swapping process, if needed.
        for(int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    flag = true;
                }
            }

            // Checking if any swapping process has done or not
            if (!flag)
                break;
        }
    }
}
