package src.Arrays.ArraysFAQs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leadersInArray {
    public List<Integer> leaders(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                list.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }

        Collections.reverse(list);

        return list;

    }
}
