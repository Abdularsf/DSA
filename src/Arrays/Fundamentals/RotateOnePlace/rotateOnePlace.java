package Arrays.Fundamentals.RotateOnePlace;

public class rotateOnePlace {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        int temp = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i - 1] = nums[i];
        }
        nums[n - 1] = temp;
    }

    public static void main(String[] args) {
        rotateOnePlace solution = new rotateOnePlace();
        int[] nums = { 1, 2, 3, 4, 5 };

        solution.rotateArrayByOne(nums);

        // Output the rotated array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
