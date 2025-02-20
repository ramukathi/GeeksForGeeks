//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String l = br.readLine();
            String[] sarr = l.split(" ");
            int[] arr = new int[sarr.length];
            for (int i1 = 0; i1 < arr.length; i1++) {
                arr[i1] = Integer.parseInt(sarr[i1]);
            }

            Solution obj = new Solution();

            int[] res = obj.twoRepeated(n, arr);
            System.out.println(res[0] + " " + res[1]);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function template for JAVA

class Solution {
    public int[] twoRepeated(int n, int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) { // If element is already in the map, it is repeated
                result[index++] = arr[i];
                if (index == 2) break; // Stop after finding two repeated elements
            } else {
                map.put(arr[i], 1);
            }
        }
        return result;
    }
}