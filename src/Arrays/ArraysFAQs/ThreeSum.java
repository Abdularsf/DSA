package src.Arrays.ArraysFAQs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    Collections.sort(temp);
                    tripletSet.add(temp);
                }
                set.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(tripletSet);
        return ans;
    }
}
