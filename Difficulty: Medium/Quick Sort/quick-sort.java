//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Sorting {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }
    // Driver program
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            new Solution().quickSort(arr, 0, n - 1);
            printArray(arr);
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int key = arr[low];  // Hoare's partition uses the first element as the pivot
        int s = low - 1;
        int e = high + 1;

        while (true) {
            do {
                s++;
            } while (arr[s] < key);  // Move s to the right until arr[s] >= pivot

            do {
                e--;
            } while (arr[e] > key);  // Move e to the left until arr[e] <= pivot

            if (s >= e) return e;  // Pointers have crossed, return pivot index

            // Swap arr[s] and arr[e]
            swap(arr, s, e);
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
