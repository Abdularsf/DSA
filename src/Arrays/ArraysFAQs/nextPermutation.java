package src.Arrays.ArraysFAQs;

public class nextPermutation {
    public void nextPermutation(int[] nums) {
        int start = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int i = n - 1; i >= start; i--) {
            if (nums[i] > nums[start]) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                break;
            }
        }
        reverse(nums, start + 1, n - 1);
        return;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
