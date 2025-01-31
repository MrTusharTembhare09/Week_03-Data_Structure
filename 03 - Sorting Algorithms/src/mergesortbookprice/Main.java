package mergesortbookprice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int bookPrices[] = {100,90,80,70,60,50,40,30,20,10};

        int n = bookPrices.length;

        mergeSort.sorting(bookPrices, 0, n-1);

        System.out.println(Arrays.toString(bookPrices));
    }
}
