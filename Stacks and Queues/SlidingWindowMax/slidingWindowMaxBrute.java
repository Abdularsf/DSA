import java.util.*;

public class slidingWindowMaxBrute {
    public List<Integer> maxSlidingWindow(int[] arr, int k) {

        int n = arr.length; // Size of array

        // To store the answer
        List<Integer> ans = new ArrayList<>();

        /*
         * Traverse on the arrary
         * for valid window
         */
        for (int i = 0; i <= n - k; i++) {

            // To store the maximum of the window
            int maxi = arr[i];

            // Traverse the window
            for (int j = i; j < i + k; j++) {
                // Update the maximum
                maxi = Math.max(maxi, arr[j]);
            }

            // Add the maximum to the result
            ans.add(maxi);
        }

        // Return the stored result
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 0, -1, 3, 5, 3, 6, 8 };
        int k = 3;

        slidingWindowMaxBrute sol = new slidingWindowMaxBrute();

        List<Integer> ans = sol.maxSlidingWindow(arr, k);

        System.out.println("The maximum elements in the sliding window are: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
