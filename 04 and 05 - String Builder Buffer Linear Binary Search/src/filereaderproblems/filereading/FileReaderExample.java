package filereaderproblems.filereading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        // Creating FileReader to read the file
        String filePath = "C:\\Users\\Tushar\\OneDrive\\Desktop\\Capgemini Training\\Week 03 - Data Structures\\04 and 05 - String Builder Buffer Linear Binary Search\\src\\filereaderproblems\\filereading\\JavaContent.txt"; // Specify the file path

        // Creating BufferedReader to read lines efficiently
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(filePath); // Creating FileReader with the file path
            bufferedReader = new BufferedReader(fileReader); // Creating BufferedReader with FileReader

            String line;
            // Reading each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Printing each line to the console
                System.out.println(line);
            }
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

