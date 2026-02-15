
public class Jump_Game {
    public boolean canJump(int[] nums) {
        int maxInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxInd) {
                return false;
            }
            maxInd = Math.max(maxInd, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 7, 1, 2 };
        Jump_Game solution = new Jump_Game();
        boolean ans = solution.canJump(nums);
        if (ans) {
            System.out.println("It is possible to reach the last index.");
        } else {
            System.out.println("It is not possible to reach the last index.");
        }
    }
}
