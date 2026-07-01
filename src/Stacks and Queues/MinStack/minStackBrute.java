import java.util.Stack;

public class minStackBrute {
    private Stack<int[]> st;

    public minStackBrute() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new int[] { val, val });
            return;
        } else {
            st.push(new int[] { val, Math.min(val, st.peek()[1]) });
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }

    public static void main(String[] args) {
        minStackBrute s = new minStackBrute();

        // Function calls
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }
}
