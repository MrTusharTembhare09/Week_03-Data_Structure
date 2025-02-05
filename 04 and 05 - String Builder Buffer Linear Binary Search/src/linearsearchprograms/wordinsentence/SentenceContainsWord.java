package linearsearchprograms.wordinsentence;

import java.util.*;

public class SentenceContainsWord {
    public static void main(String[] args) {
        // Defining scanner class
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of sentences in an array : ");
        // Taking size of an array from user
        int n = input.nextInt();

        // Specifying array of type string of size n
        String[] sentences = new String[n];

        // Getting all the sentences from user
        int i = 0;
        while(i < n) {
            System.out.println("Enter sentence for index number " + i + " : ");
            sentences[i] = input.nextLine();
            i++;
        }

        // Getting target word
        System.out.print("Enter the target word : ");
        String targetWord = input.next();

        boolean result = false;

        // Iterating over an input array of strings
        for(String a : sentences) {
            // Checking if target word is present in sentence a or not
            if(a.contains(targetWord)) {
                System.out.print("The target word is present in this sentence : " + a);
                result = true;
            }
        }

        // Target word is not present in any of the sentences
        if(!result)
            System.out.println("Not found");
    }
}
