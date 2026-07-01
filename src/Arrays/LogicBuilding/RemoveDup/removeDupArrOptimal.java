package Arrays.LogicBuilding.RemoveDup;

public class removeDupArrOptimal {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3, 3 };

        // Create an instance of the Solution class
        removeDupArrOptimal solution = new removeDupArrOptimal();

        // Call removeDuplicates to remove duplicates from nums
        int k = solution.removeDuplicates(nums);

        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
