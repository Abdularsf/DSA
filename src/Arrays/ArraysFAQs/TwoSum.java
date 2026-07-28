package src.Arrays.ArraysFAQs;

import java.util.ArrayList;
import java.util.Collections;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Map<Integer,Integer> mpp = new HashMap<>();
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Pair(nums[i], i));
        }
        Collections.sort(list, (a, b) -> a.first - b.first);
        System.out.println(nums);
        int n = nums.length;
        int[] ans = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int total = list.get(left).first + list.get(right).first;
            if (total > target) {
                right--;
            } else if (total < target) {
                left++;
            } else {
                ans[0] = list.get(left).second;
                ans[1] = list.get(right).second;
                break;
            }
        }
        return ans;
    }
}
