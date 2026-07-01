package src.Arrays.Fundamentals.LargestElement;

public class largestElement {

    public int findLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 2 };

        largestElement sol = new largestElement();

        System.out.println("The largest element is: " + sol.findLargest(nums));
    }
}