package stringbuilderproblems.removeduplicatesusingstringbuilder;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {

    public static String removeDuplicates(String str) {
        // Creating StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Creating HashSet to store unique characters
        HashSet<Character> seen = new HashSet<>();

        // Iterating through the string
        for (char ch : str.toCharArray()) {
            // Checking if character is already in HashSet
            if (!seen.contains(ch)) {
                // Appending unique character to StringBuilder
                sb.append(ch);
                // Adding character to HashSet
                seen.add(ch);
            }
        }

        // Converting StringBuilder back to String and returning
        return sb.toString();
    }

    public static void main(String[] args) {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");

        // Reading input string from user
        String input = scanner.nextLine();

        // Removing duplicates using StringBuilder
        String uniqueString = removeDuplicates(input);

        // Printing the string without duplicates
        System.out.println("String without duplicates: " + uniqueString);

        // Closing the scanner
        scanner.close();
    }
}

