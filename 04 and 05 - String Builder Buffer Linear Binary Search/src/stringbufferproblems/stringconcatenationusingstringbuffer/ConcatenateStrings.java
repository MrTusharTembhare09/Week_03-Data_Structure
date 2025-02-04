package stringbufferproblems.stringconcatenationusingstringbuffer;

import java.util.HashSet;
import java.util.Scanner;

public class ConcatenateStrings {

    public static String concatenateStrings(String[] strings) {
        // Creating StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Iterating through the array and appending each string
        for (String str : strings) {
            sb.append(str);
        }

        // Converting StringBuffer to String and returning
        return sb.toString();
    }

    public static void main(String[] args) {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of strings: ");

        // Reading number of strings
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Creating array to store strings
        String[] strings = new String[n];

        // Reading strings from user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        // Concatenating strings using StringBuffer
        String concatenatedString = concatenateStrings(strings);

        // Printing the concatenated string
        System.out.println("Concatenated string: " + concatenatedString);

        // Closing the scanner
        scanner.close();
    }
}
