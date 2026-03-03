import java.util.Stack;

public class histogramBrute {
    public int largestRectangleArea(int[] heights) {
        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (nse[i] - pse[i] - 1) * heights[i]);
        }
        return max;
    }

    private int[] findNSE(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
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

    private int[] findPSE(int[] arr) {
        int[] pse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
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
        int[] heights = { 2, 1, 5, 6, 2, 3 };

        histogramBrute sol = new histogramBrute();

        int ans = sol.largestRectangleArea(heights);

        System.out.println("The largest rectangle area is: " + ans);
    }
}
