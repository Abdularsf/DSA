package Arrays.Fundamentals.MaxConsecutiveOnes;

public class maxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 1, 0, 1, 1, 1 };

        // Create an instance of the Solution class
        maxConsecutiveOnes sol = new maxConsecutiveOnes();

        // Find and print the maximum consecutive 1s
        int ans = sol.findMaxConsecutiveOnes(nums);
        System.out.println("The maximum consecutive 1's are " + ans);
    }
}
