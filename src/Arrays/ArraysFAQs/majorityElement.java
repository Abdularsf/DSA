package src.Arrays.ArraysFAQs;

class majorityElement {
    public int majorityElem(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int el = 0;

        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                el = nums[i];
                cnt++;
            } else if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return el;
    }
}