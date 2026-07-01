
public class consecutive_ones_better {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int zeros = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        consecutive_ones_better sol = new consecutive_ones_better();
        int[] input = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int length = sol.longestOnes(input, k);
        System.out.println("Length of longest substring with at most " + k + " zeros: " + length);
    }
}