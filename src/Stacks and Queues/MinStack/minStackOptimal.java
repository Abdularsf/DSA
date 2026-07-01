import java.util.Stack;

public class minStackOptimal {
    private Stack<Integer> st;
    private int min;

    public minStackOptimal() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min = val;
            return;
        } else if (val > min) {
            st.push(val);
        } else {
            int newVal = 2 * val - min;
            st.push(newVal);
            min = val;
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;
        int x = st.pop();
        if (x < min) {
            min = 2 * min - x;
        }
    }

    public int top() {
        if (st.isEmpty())
            return -1;
        if (st.peek() < min) {
            return min;
        }
        return st.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        minStackOptimal s = new minStackOptimal();

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
