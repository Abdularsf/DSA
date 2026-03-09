package Arrays.Fundamentals.SecondLargest;

import java.util.Arrays;

public class secondLargestBetter {
    public int secondLargestElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int largest = nums[n - 1];
        int secondLargest = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (largest != nums[i]) {
                secondLargest = nums[i];
                break;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6, 7, 5 };

        // Create an instance of the Solution class
        secondLargestBetter sol = new secondLargestBetter();

        /*
         * Call the method to find
         * the second largest element
         */
        int ans = sol.secondLargestElement(nums);

        System.out.println("The second largest element is: " + ans);
    }
}
