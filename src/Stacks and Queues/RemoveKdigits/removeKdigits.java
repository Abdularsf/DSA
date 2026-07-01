import java.util.Stack;

public class removeKdigits {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        int n = nums.length();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > nums.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(nums.charAt(i));
        }
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty())
            return "0";
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }
        if (res.length() == 0)
            return "0";
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String nums = "541892";
        int k = 2;
        removeKdigits sol = new removeKdigits();
        String ans = sol.removeKdigits(nums, k);
        System.out.println("The smallest possible integer after removing k digits is: " + ans);
    }
}
