package Arrays.LogicBuilding.RemoveDup;

import java.util.Set;
import java.util.TreeSet;

public class removeDupArrBrute {

    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        for (int val : nums) {
            s.add(val);
        }
        int k = s.size();

        int j = 0;

        for (int val : s) {
            nums[j++] = val;
        }
        return k;
    }

    public static void printArray(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3, 3 };

        System.out.print("Original Array: ");
        printArray(nums, nums.length);

        // Create an instance of the Solution class
        removeDupArrBrute sol = new removeDupArrBrute();

        // Function call to remove duplicates from array
        int k = sol.removeDuplicates(nums);

        System.out.print("Array after removing the duplicates: ");
        printArray(nums, k);
    }
}
