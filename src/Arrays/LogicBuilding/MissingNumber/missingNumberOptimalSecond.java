package Arrays.LogicBuilding.MissingNumber;

public class missingNumberOptimalSecond {
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }
        return (xor1 ^ xor2);
    }

    public static void main(String[] args) {
        // Example array with missing number
        int[] nums = { 0, 1, 2, 4 };

        // Create an instance of the Solution class
        missingNumberOptimalSecond solution = new missingNumberOptimalSecond();

        int ans = solution.missingNumber(nums);

        System.out.println("The missing number is: " + ans);
    }
}
