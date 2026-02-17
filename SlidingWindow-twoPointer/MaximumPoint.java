
public class MaximumPoint {
    public int maxScore(int[] cardScore, int k) {
        int n = cardScore.length;
        int leftSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum = leftSum + cardScore[i];
        }
        maxSum = leftSum;
        int rightSum = 0;
        int rightInd = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum = leftSum - cardScore[i];
            rightSum = rightSum + cardScore[rightInd];
            rightInd--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };

        // Create an instance of the Solution class
        MaximumPoint sol = new MaximumPoint();

        int result = sol.maxScore(nums, 3);

        // Output the maximum score
        System.out.println("The maximum score is:");
        System.out.println(result);
    }
}
