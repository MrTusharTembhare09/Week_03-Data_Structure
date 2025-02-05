package inputstreamreaderproblems.userinputfile;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // Defining the output file path
        String filePath = "C:\\Users\\Tushar\\OneDrive\\Desktop\\Capgemini Training\\Week 03 - Data Structures\\04 and 05 - String Builder Buffer Linear Binary Search\\src\\inputstreamreaderproblems\\userinputfile\\user_input.txt"; // The file where input will be stored

        // Creating InputStreamReader to read user input
        InputStreamReader inputStreamReader = null;
        // Creating BufferedReader for efficient input reading
        BufferedReader bufferedReader = null;
        // Creating FileWriter to write user input to a file
        FileWriter fileWriter = null;
        // Creating BufferedWriter for efficient file writing
        BufferedWriter bufferedWriter = null;

        try {
            inputStreamReader = new InputStreamReader(System.in); // Reading user input from the console
            bufferedReader = new BufferedReader(inputStreamReader); // Wrapping InputStreamReader in BufferedReader

            fileWriter = new FileWriter(filePath, true); // Opening file in append mode
            bufferedWriter = new BufferedWriter(fileWriter); // Wrapping FileWriter in BufferedWriter

            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            // Reading user input continuously until "exit" is entered
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(userInput); // Writing user input to the file
                bufferedWriter.newLine(); // Moving to the next line
            }

            System.out.println("User input has been saved to " + filePath);

        } catch (IOException e) {
            // Handling any IOException that occurs during reading or writing
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                // Closing BufferedReader, BufferedWriter, InputStreamReader, and FileWriter
                if (bufferedReader != null) bufferedReader.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (bufferedWriter != null) bufferedWriter.close();
                if (fileWriter != null) fileWriter.close();
            } catch (IOException e) {
                // Handling any errors during closing
                System.out.println("An error occurred while closing resources: " + e.getMessage());
            }
        }
    }
}
