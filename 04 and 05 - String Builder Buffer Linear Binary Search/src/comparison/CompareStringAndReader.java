package comparison;

import java.io.*;

public class CompareStringAndReader {
    public static void main(String[] args) {
        // Comparing StringBuilder and StringBuffer
        compareStringPerformance();

        // Comparing FileReader and InputStreamReader for word count in a large file
        String filePath = "C:\\Users\\Tushar\\OneDrive\\Desktop\\Capgemini Training\\Week 03 - Data Structures\\04 and 05 - String Builder Buffer Linear Binary Search\\src\\comparison\\largefile.txt"; // Ensure this file exists before running the program
        countWordsUsingFileReader(filePath);
        countWordsUsingInputStreamReader(filePath);
    }

    // Comparing performance of StringBuilder and StringBuffer
    public static void compareStringPerformance() {
        String text = "hello";
        int iterations = 1_000_000;

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        long startTimeSB = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTimeSB = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTimeSB - startTimeSB) / 1_000_000 + " ms");

        // Using StringBuffer
        StringBuffer sbf = new StringBuffer();
        long startTimeSBF = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        long endTimeSBF = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTimeSBF - startTimeSBF) / 1_000_000 + " ms");
    }

    // Count words using FileReader
    public static void countWordsUsingFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            long startTime = System.nanoTime();
            int wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            long endTime = System.nanoTime();

            System.out.println("FileReader - Word Count: " + wordCount);
            System.out.println("Time taken by FileReader: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
    }

    // Count words using InputStreamReader
    public static void countWordsUsingInputStreamReader(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            long startTime = System.nanoTime();
            int wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            long endTime = System.nanoTime();

            System.out.println("InputStreamReader - Word Count: " + wordCount);
            System.out.println("Time taken by InputStreamReader: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
}

