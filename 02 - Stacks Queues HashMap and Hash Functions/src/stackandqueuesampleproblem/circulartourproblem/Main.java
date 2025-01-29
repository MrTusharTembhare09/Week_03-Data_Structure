package stackandqueuesampleproblem.circulartourproblem;

// Main class to test Circular Tour Problem
class Main {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        // Finding the starting petrol pump index
        int start = CircularTour.findStartingPoint(petrol, distance);

        // Printing the result
        if (start != -1) {
            System.out.println("Start at petrol pump index: " + start);
        } else {
            System.out.println("No valid starting point for completing the tour");
        }
    }
}
