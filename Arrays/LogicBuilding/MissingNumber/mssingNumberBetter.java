package Arrays.LogicBuilding.MissingNumber;

public class mssingNumberBetter {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++) {
            hash[nums[i]] = 1;
        }

        for (int i = 0; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4 };

        // Create an instance of the Solution class
        mssingNumberBetter solution = new mssingNumberBetter();

        /*
         * Call the missingNumber method
         * to find the missing number
         */
        int ans = solution.missingNumber(nums);

        System.out.println("The missing number is: " + ans);
    }
}
