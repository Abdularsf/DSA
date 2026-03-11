package Arrays.LogicBuilding.MissingNumber;

public class missingNumberOptimal {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum1 = (n * (n + 1)) / 2;

        int sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum2 += nums[i];
        }

        int missingNum = sum1 - sum2;

        return missingNum;
    }

    public static void main(String[] args) {

        int[] nums = { 0, 1, 2, 4 };

        missingNumberOptimal solution = new missingNumberOptimal();

        int ans = solution.missingNumber(nums);

        System.out.println("The missing number is: " + ans);
    }
}
