package stringreverseusingstringbuilder;

import java.util.Scanner;

public class ReverseString {

    public static String reverseString(String str) {
        // Creating StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Appending input string to StringBuilder
        sb.append(str);

        // Reversing the string using reverse() method
        sb.reverse();

        // Converting StringBuilder back to String and returning
        return sb.toString();
    }

    public static void main(String[] args) {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");

        // Reading input string from user
        String input = scanner.nextLine();

        // Reversing the string using StringBuilder
        String reversedString = reverseString(input);

        // Printing the reversed string
        System.out.println("Reversed string: " + reversedString);

        // Closing the scanner
        scanner.close();
    }
}

