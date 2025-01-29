package stackandqueuesampleproblem.circulartourproblem;

import java.util.Queue;
import java.util.LinkedList;

// Solving Circular Tour Problem using Queue
class CircularTour {
    // Finding the starting petrol pump index for completing the circular tour
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0, deficit = 0, surplus = 0;

        for (int i = 0; i < petrol.length; i++) {
            surplus += petrol[i] - distance[i]; // Calculating net petrol at each pump

            // If surplus becomes negative, reset starting point
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus; // Store the deficit
                surplus = 0; // Reset surplus
            }
        }

        return (surplus + deficit >= 0) ? start : -1; // Checking if tour is possible
    }
}
