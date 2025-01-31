package Insertionsortemployeeid;

public class Main {
    public static void main(String[] args) {
        int EmployeeID[] = {34,35,27,68,12};

        InsertionSort.sorting(EmployeeID);

        System.out.print("Employee ID array in ascending order is : ");
        for(int i = 0; i < EmployeeID.length; i++) {
            System.out.print(EmployeeID[i] + " ");
        }
        System.out.println();
    }
}
