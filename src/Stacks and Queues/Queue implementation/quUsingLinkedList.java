class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}

public class quUsingLinkedList {
    private Node start;
    private Node end;
    private int size;

    public quUsingLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    public void push(int x) {
        Node temp = new Node(x);
        if (size == 0) {
            start = temp;
            end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        int value = start.val;
        start = start.next;
        size--;
        if (start == null) {
            end = null;
        }
        return value;
    }

    public int peek() {
        if (start == null) {
            return -1;
        }
        return start.val;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String[] args) {
        // Creating a queue
        quUsingLinkedList q = new quUsingLinkedList();

        // Array of commands
        String[] commands = { "LinkedListQueue", "push", "push",
                "peek", "pop", "isEmpty" };
        // Array of inputs
        int[][] inputs = { {}, { 3 }, { 7 }, {}, {}, {} };

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListQueue")) {
                System.out.print("null ");
            }
        }
    }
}
