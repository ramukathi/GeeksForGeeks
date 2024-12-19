//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // Length of the two arrays
         int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0;

        // List to store the union
        ArrayList<Integer> union = new ArrayList<>();

        // Traverse both arrays and merge their elements
        while (i < n1 && j < n2) {
            // Skip duplicate elements in array a
            while (i > 0 && i < n1 && a[i] == a[i - 1]) i++;
            // Skip duplicate elements in array b
            while (j > 0 && j < n2 && b[j] == b[j - 1]) j++;

            if (i >= n1 || j >= n2) break; // Exit if we cross bounds after skipping duplicates

            if (a[i] < b[j]) {
                union.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                union.add(b[j]);
                j++;
            } else {
                // Both elements are the same; add either and move both pointers
                union.add(a[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements of array a
        while (i < n1) {
            while (i > 0 && i < n1 && a[i] == a[i - 1]) i++; // Skip duplicates
            if (i < n1) union.add(a[i++]);
        }

        // Add remaining elements of array b
        while (j < n2) {
            while (j > 0 && j < n2 && b[j] == b[j - 1]) j++; // Skip duplicates
            if (j < n2) union.add(b[j++]);
        }

        return union;
    }
}
