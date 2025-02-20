//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        if (arr == null || arr.length < 2) return new ArrayList<>(); // Edge case: empty or single-element array

        Arrays.sort(arr); // Sorting the array
        int left = 0, right = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int closestLeft = -1, closestRight = -1; // Initialize with -1 to indicate no valid pair found

        while (left < right) {
            int currSum = arr[left] + arr[right];

            // If this sum is closer to the target, update the closest sum and indices
            if (Math.abs(target - currSum) < Math.abs(target - closestSum)) {
                closestSum = currSum;
                closestLeft = arr[left];
                closestRight = arr[right];
            }

            // Move pointers based on the sum
            if (currSum < target) {
                left++;  // Need a larger sum, move left pointer
            } else {
                right--; // Need a smaller sum, move right pointer
            }
        }

        // If no valid pair was found, return an empty list
        if (closestLeft == -1 && closestRight == -1) {
            return new ArrayList<>();
        }

        return Arrays.asList(closestLeft, closestRight);
    }

    
}

