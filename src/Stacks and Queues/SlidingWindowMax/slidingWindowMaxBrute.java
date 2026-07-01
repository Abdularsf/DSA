import java.util.*;

public class slidingWindowMaxBrute {
    public List<Integer> maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {

            int maxi = arr[i];

            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, arr[j]);
            }
            ans.add(maxi);
        }

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
