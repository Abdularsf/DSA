package Arrays.Fundamentals.LargestElement;

public class largestElement {
    public int largestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 2 };

        // Create an instance of the Solution class
        largestElement sol = new largestElement();

        // Find and print the largest element in the array
        System.out.println("The largest element in the array is: " + sol.largestElement(nums));
    }
}
