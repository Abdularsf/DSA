
public class moveZerostoEndOptimal {

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

    }

    public static void main(String[] args) {
        // Input array
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };

        // Create Solution instance and move zeroes
        moveZerostoEndOptimal sol = new moveZerostoEndOptimal();
        sol.moveZeroes(arr);

        // Print updated array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
