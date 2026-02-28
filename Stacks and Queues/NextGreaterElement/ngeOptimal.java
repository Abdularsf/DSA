import java.util.Stack;

public class ngeOptimal {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = -1;
                st.push(arr[i]);
            } else {
                nge[i] = st.peek();
                st.push(arr[i]);
            }
        }
        return nge;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 3, 2, 4 };

        /*
         * Creating an instance of
         * Solution class
         */
        ngeOptimal sol = new ngeOptimal();

        /*
         * Function call to find the next greater
         * element for each element in the array
         */
        int[] ans = sol.nextLargerElement(arr);

        System.out.println("The next greater elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
