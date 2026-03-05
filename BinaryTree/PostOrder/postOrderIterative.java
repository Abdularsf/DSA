package BinaryTree.PostOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize a node with a value
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class postOrderIterative {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.data);
            if (node.left != null)
                st.push(node.left);
            if (node.right != null)
                st.push(node.right);
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        postOrderIterative sol = new postOrderIterative();
        // Getting postorder traversal
        List<Integer> result = sol.postorder(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        // printList(result);
    }
}
