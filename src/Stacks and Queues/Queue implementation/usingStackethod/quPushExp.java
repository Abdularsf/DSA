import java.util.Stack;

public class quPushExp {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        while (s1.size() != 0) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (s2.size() != 0) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean isEmpty() {
        return (s1.size() == 0);
    }

    public static void main(String[] args) {
        quPushExp q = new quPushExp();

        String[] commands = { "StackQueue", "push", "push",
                "pop", "peek", "isEmpty" };

        int[][] inputs = { {}, { 4 }, { 8 }, {}, {}, {} };

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("StackQueue")) {
                System.out.print("null ");
            }
        }
    }
}
