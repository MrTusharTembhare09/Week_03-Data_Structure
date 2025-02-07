package stringconcatenation;

public class StringConcatenationComparison {

    public static void main(String[] args) {
        int iterations = 100000; // Reduced iterations for testing

        // Using String (Inefficient)
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        long endTime = System.nanoTime();
        System.out.println("String Concatenation Time: " + (endTime - startTime) / 1e6 + " ms");
        System.out.flush();

        // Using StringBuilder (Efficient for single-threaded operations)
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Concatenation Time: " + (endTime - startTime) / 1e6 + " ms");
        System.out.flush();

        // Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Concatenation Time: " + (endTime - startTime) / 1e6 + " ms");
        System.out.flush();
    }
}


