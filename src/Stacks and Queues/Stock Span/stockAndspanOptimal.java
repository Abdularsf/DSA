import java.util.Stack;

public class stockAndspanOptimal {
    public int[] stockSpan(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] span = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                int diff = i - st.peek();
                span[i] = diff;
            }
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] arr = { 120, 100, 60, 80, 90, 110, 115 };

        stockAndspanBrute sol = new stockAndspanBrute();

        int[] ans = sol.stockSpan(arr, n);

        System.out.print("The span of stock prices is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
