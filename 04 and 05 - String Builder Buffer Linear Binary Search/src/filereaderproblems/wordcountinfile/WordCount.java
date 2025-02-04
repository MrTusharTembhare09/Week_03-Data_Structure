package filereaderproblems.wordcountinfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {
        // Defining file path and target word
        String filePath = "C:\\Users\\Tushar\\OneDrive\\Desktop\\Capgemini Training\\Week 03 - Data Structures\\04 and 05 - String Builder Buffer Linear Binary Search\\src\\filereaderproblems\\wordcountinfile\\wordcounttext.txt"; // Change this to your file path
        String targetWord = "file"; // Change this to the word you want to count

        // Creating FileReader to read the file
        FileReader fileReader = null;
        // Creating BufferedReader to read the file line by line
        BufferedReader bufferedReader = null;

        int wordCount = 0; // Initializing counter to track word occurrences

        try {
            fileReader = new FileReader(filePath); // Creating FileReader with the file path
            bufferedReader = new BufferedReader(fileReader); // Creating BufferedReader with FileReader

            String line;
            // Reading each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Splitting line into words
                String[] words = line.split("\\s+");

                // Checking for word occurrences
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // Ignoring case sensitivity
                        wordCount++; // Incrementing the counter when a match is found
                    }
                }
            }

            // Printing the final word count
            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");

        } catch (IOException e) {
            // Handling any IOException that occurs during reading
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                // Closing BufferedReader and FileReader
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                // Handling any IOException that occurs during closing
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}

