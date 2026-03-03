import java.util.*;

public class slidingWindowMaxOptimal {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] nums = new int[n - k + 1];
        int ansIndex = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= (k - 1)) {
                nums[ansIndex++] = arr[dq.peekFirst()];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 0, -1, 3, 5, 3, 6, 8 };
        int k = 3;
        slidingWindowMaxOptimal sol = new slidingWindowMaxOptimal();
        int[] ans = sol.maxSlidingWindow(arr, k);

        System.out.println("The maximum elements in the sliding window are: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
