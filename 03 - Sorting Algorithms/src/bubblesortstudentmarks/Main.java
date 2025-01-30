package bubblesortstudentmarks;

public class Main {
    public static void main(String[] args) {
        int marks[] = {67, 56, 81, 78, 66, 93};

        // Sorting in ascending order
        BubbleSort.sorting(marks);

        System.out.print("Marks array of students in ascending order is : ");
        for(int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }
}
