import java.util.Stack;

public class subArrSumOptimalRange {
    public long subArrayRanges(int[] nums) {
        return sumSubArrayMax(nums) - sumSubArrayMin(nums);
    }

    private long sumSubArrayMin(int[] nums) {
        int[] nse = findNSE(nums);
        int[] psee = findPSEE(nums);
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            sum += 1L * left * right * nums[i];
        }
        return sum;
    }

    private long sumSubArrayMax(int[] nums) {
        int[] nle = findNLE(nums);
        int[] plee = findPLEE(nums);
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - plee[i];
            int right = nle[i] - i;
            sum += 1L * left * right * nums[i];
        }
        return sum;
    }

    private int[] findNLE(int[] nums) {
        int n = nums.length;
        int[] nle = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            int curr = nums[i];

            while (!st.isEmpty() && nums[st.peek()] <= curr) {
                st.pop();
            }

            nle[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return nle;
    }

    private int[] findPLEE(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ple = new int[nums.length];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ple[i] = -1;
            } else {
                ple[i] = st.peek();
            }
            st.push(i);
        }
        return ple;
    }

    private int[] findNSE(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nse = new int[nums.length];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    private int[] findPSEE(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] pse = new int[nums.length];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        subArrSumOptimalRange sol = new subArrSumOptimalRange();
        long ans = sol.subArrayRanges(arr);

        System.out.println("The sum of subarray ranges is: " + ans);
    }
}
