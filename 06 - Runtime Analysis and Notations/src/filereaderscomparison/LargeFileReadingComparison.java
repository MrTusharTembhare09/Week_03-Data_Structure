package filereaderscomparison;

import java.io.*;

public class LargeFileReadingComparison {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Tushar\\OneDrive\\Desktop\\Capgemini Training\\Week 03 - Data Structures\\06 - Runtime Analysis and Notations\\src\\filereaderscomparison\\largefile.txt"; // Ensure this file exists

        // FileReader Approach (Character Stream)
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {
            while (br.readLine() != null) {
                // Just reading, no processing
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader Read Time: " + (endTime - startTime) / 1e6 + " ms");

        // InputStreamReader Approach (Byte Stream -> Character Stream)
        startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null) {
                // Just reading, no processing
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Read Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
