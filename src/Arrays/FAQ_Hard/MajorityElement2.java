package src.Arrays.FAQ_Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElementTwo(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int element = 0, element2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && element2 != nums[i]) {
                cnt1++;
                element = nums[i];
            } else if (cnt2 == 0 && element != nums[i]) {
                cnt2++;
                element2 = nums[i];
            } else if (element == nums[i]) {
                cnt1++;
            } else if (element2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                cnt1++;
            }
            if (nums[i] == element2) {
                cnt2++;
            }
        }

        int mini = n / 3 + 1;

        List<Integer> result = new ArrayList<>();
        if (cnt1 >= mini) {
            result.add(element);
        }
        if (cnt2 >= mini && element != element2) {
            result.add(element2);
        }

        return result;
    }
}
