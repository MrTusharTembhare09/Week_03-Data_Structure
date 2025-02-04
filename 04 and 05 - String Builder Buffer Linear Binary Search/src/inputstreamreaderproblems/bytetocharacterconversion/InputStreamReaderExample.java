package inputstreamreaderproblems.bytetocharacterconversion;

import java.io.*;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        // Defining the file path
        String filePath = "C:\\Users\\Tushar\\OneDrive\\Desktop\\Capgemini Training\\Week 03 - Data Structures\\04 and 05 - String Builder Buffer Linear Binary Search\\src\\inputstreamreaderproblems\\bytetocharacterconversion\\binarydata.txt"; // Ensure this file exists in the correct location

        // Creating FileInputStream to read the binary data
        FileInputStream fileInputStream = null;
        // Creating InputStreamReader to convert bytes to characters
        InputStreamReader inputStreamReader = null;
        // Creating BufferedReader for efficient reading
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(filePath); // Opening file in byte stream mode
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8"); // Converting byte stream to character stream
            bufferedReader = new BufferedReader(inputStreamReader); // Wrapping InputStreamReader for efficient reading

            String line;
            // Reading file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Printing each line to the console
            }

        } catch (FileNotFoundException e) {
            // Handling case when file is not found
            System.out.println("The specified file was not found: " + e.getMessage());
        } catch (IOException e) {
            // Handling any I/O errors
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                // Closing BufferedReader, InputStreamReader, and FileInputStream
                if (bufferedReader != null) bufferedReader.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (fileInputStream != null) fileInputStream.close();
            } catch (IOException e) {
                // Handling errors during closing
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}
