import java.util.Stack;

public class subArrSumOptimal {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        int n = arr.length;
        int sum = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            int val = (int) ((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum;
    }

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
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

    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                psee[i] = -1;
            } else {
                psee[i] = st.peek();
            }
            st.push(i);
        }
        return psee;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5 };
        subArrSumOptimal sol = new subArrSumOptimal();
        int ans = sol.sumSubarrayMins(arr);

        System.out.println("The sum of minimum value in each subarray is: " + ans);
    }
}
