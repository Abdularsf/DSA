
public class consecutive_ones_brute {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }
                if (zeros <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                } else
                    break;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        consecutive_ones_brute sol = new consecutive_ones_brute();
        int[] input = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int length = sol.longestOnes(input, k);
        System.out.println("Length of longest substring with at most " + k + " zeros: " + length);
    }
}
