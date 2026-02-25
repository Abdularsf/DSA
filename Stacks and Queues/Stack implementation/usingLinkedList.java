public class usingLinkedList {
    private Node top;
    private int size;

    public usingLinkedList() {
        top = null;
        size = 0;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ✅ MAIN METHOD HERE
    public static void main(String[] args) {
        usingLinkedList st = new usingLinkedList();

        String[] commands = { "LinkedListStack", "push", "push",
                "pop", "top", "isEmpty" };

        int[][] inputs = { {}, { 3 }, { 7 }, {}, {}, {} };

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                st.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(st.pop() + " ");
            } else if (commands[i].equals("top")) {
                System.out.print(st.top() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((st.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListStack")) {
                System.out.print("null ");
            }
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}