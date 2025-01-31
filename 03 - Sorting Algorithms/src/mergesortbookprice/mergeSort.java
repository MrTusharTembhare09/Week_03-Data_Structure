package mergesortbookprice;

public class mergeSort {
     public static void sorting(int bookPrices[], int left, int right) {
         if(left < right) {
             int mid = left + (right-left)/2;

             sorting(bookPrices, left, mid);
             sorting(bookPrices, mid+1, right);

             Merge.merge(bookPrices, left, mid, right);
         }
     }
}
