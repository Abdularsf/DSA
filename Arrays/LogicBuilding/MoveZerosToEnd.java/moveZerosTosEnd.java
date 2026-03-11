import java.util.Arrays;

public class moveZerosTosEnd {

    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[count++] = nums[i];
            }
        }

        for (int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }

        for (int i = count; i < n; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };

        // Create an instance of Solution class
        moveZerosTosEnd sol = new moveZerosTosEnd();
        sol.moveZeroes(nums);

        System.out.print("Array after moving zeroes: ");
        // Print the modified array
        System.out.println(Arrays.toString(nums));
    }
}
