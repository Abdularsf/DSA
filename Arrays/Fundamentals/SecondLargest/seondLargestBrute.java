package Arrays.Fundamentals.SecondLargest;

import java.util.Arrays;

public class seondLargestBrute {

    public int secondLargestElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int largest = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != largest) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6, 7, 5 };

        seondLargestBrute sol = new seondLargestBrute();

        int ans = sol.secondLargestElement(nums);

        System.out.println("The second largest element is: " + ans);
    }
}
