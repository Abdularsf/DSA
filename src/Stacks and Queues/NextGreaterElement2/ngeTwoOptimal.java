import java.util.Stack;

public class ngeTwoOptimal {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i % n]) {
                st.pop();
            }
            if (i < n) {
                if (st.isEmpty())
                    nge[i] = -1;
                else
                    nge[i] = st.peek();
            }
            st.push(arr[i % n]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 5, 7, 1, 7, 6, 0 };
        ngeTwoOptimal sol = new ngeTwoOptimal();
        int[] ans = sol.nextGreaterElements(arr);

        System.out.println("The next greater elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
