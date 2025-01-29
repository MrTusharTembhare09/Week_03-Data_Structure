package stackandqueuesampleproblem.stockspanproblem;

// Main class to test stock span calculation
class Main {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        // Calculating span for given prices
        int[] span = StockSpan.calculateSpan(prices);

        // Printing the span values
        System.out.print("Stock Span: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
