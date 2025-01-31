package selectionsortexamscores;

import java.util.*;

public class SelectionSort {

    private static void sorting(int examScores[]) {

        int n = examScores.length;

        for(int i = 0; i < n-1; i++) {
            int smallestIndex = i;
            for(int j = i+1; j < n; j++) {
                if(examScores[j] < examScores[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            int temp = examScores[i];
            examScores[i] = examScores[smallestIndex];
            examScores[smallestIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int examScores[] = {90,80,78,45,12};

        sorting(examScores);

        System.out.print("Exam score array of students in ascending order is : ");
        for(int i = 0; i < examScores.length; i++) {
            System.out.print(examScores[i] + " ");
        }
        System.out.println();
    }
}
