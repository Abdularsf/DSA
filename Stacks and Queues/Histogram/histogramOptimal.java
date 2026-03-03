import java.util.Stack;

public class histogramOptimal {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = -1;
                if (st.isEmpty()) {
                    pse = -1;
                } else {
                    pse = st.peek();
                }
                max = Math.max(max, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int nse = n;
            int element = st.pop();
            int pse = -1;
            if (st.isEmpty()) {
                pse = -1;
            } else {
                pse = st.peek();
            }
            max = Math.max(max, heights[element] * (nse - pse - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };

        histogramOptimal sol = new histogramOptimal();

        int ans = sol.largestRectangleArea(heights);

        System.out.println("The largest rectangle area is: " + ans);
    }
}
