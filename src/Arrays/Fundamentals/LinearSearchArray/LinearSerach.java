package Arrays.Fundamentals.LinearSearchArray;

public class LinearSerach {
    public int linearSearch(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int target = 4;

        // Create an instance of the Solution class
        LinearSerach sol = new LinearSerach();

        // Call the linearSearch method
        int result = sol.linearSearch(nums, target);

        System.out.println(result);
    }
}
