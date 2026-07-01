import java.util.*;

public class stUsingArrays {
    private int[] stackArray;
    // private int capacity;
    private int top = -1;

    public stUsingArrays() {
        stackArray = new int[10];
    }

    public stUsingArrays(int size) {
        stackArray = new int[size];
    }

    public void push(int x) {
        if (top == stackArray.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stackArray[top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stackArray[top--];
    }

    public int top() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        stUsingArrays stack = new stUsingArrays();
        List<String> commands = Arrays.asList("ArrayStack", "push", "push", "top", "pop", "isEmpty");
        List<List<Integer>> inputs = Arrays.asList(Arrays.asList(), Arrays.asList(5), Arrays.asList(10),
                Arrays.asList(), Arrays.asList(), Arrays.asList());
        for (int i = 0; i < commands.size(); ++i) {
            switch (commands.get(i)) {
                case "push":
                    stack.push(inputs.get(i).get(0));
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(stack.pop() + " ");
                    break;
                case "top":
                    System.out.print(stack.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print((stack.isEmpty() ? "true" : "false") + " ");
                    break;
                case "ArrayStack":
                    System.out.print("null ");
                    break;
            }
        }
    }

}
