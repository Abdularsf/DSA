import java.util.*;

class Node {
    int key, val;
    Node next, prev;

    Node() {
        key = val = -1;
        next = prev = null;
    }

    Node(int k, int value) {
        key = k;
        val = value;
        next = prev = null;
    }
}

class LRUCache {

    private Map<Integer, Node> mpp;
    private int capacity;
    private Node head;
    private Node tail;

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nxtNode = node.next;

        prevNode.next = nxtNode;
        nxtNode.prev = prevNode;
    }

    private void insertionNode(Node node) {
        Node nxtElem = head.next;
        head.next = node;
        node.prev = head;
        nxtElem.prev = node;
        node.next = nxtElem;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mpp = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!mpp.containsKey(key)) {
            return -1;
        }
        Node node = mpp.get(key);
        int val = node.val;

        deleteNode(node);
        insertionNode(node);

        return val;
    }

    public void put(int key, int value) {
        if (mpp.containsKey(key)) {
            Node node = mpp.get(key);
            node.val = value;

            deleteNode(node);
            insertionNode(node);
            return;
        }
        if (mpp.size() == capacity) {

            Node node = tail.prev;

            mpp.remove(node.key);

            deleteNode(node);
        }
        Node newNode = new Node(key, value);
        mpp.put(key, newNode);
        insertionNode(newNode);
    }

    public static void main(String[] args) {
        // LRU Cache
        LRUCache cache = new LRUCache(2);

        // Queries
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(1) + " ");
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
    }

}