package BinaryTree.Traversal.PreInPost;

import java.util.ArrayList;
import java.util.Arrays;
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

class elemStruct {
    TreeNode node;
    int state;

    elemStruct(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class preInPost {
    List<List<Integer>> treeTraversal(TreeNode root) {
        Stack<elemStruct> st = new Stack<>();
        // TreeNode node = root;
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if (root == null)
            return Arrays.asList(pre, in, post);
        st.push(new elemStruct(root, 1));
        while (!st.isEmpty()) {
            elemStruct top = st.pop();
            int num = top.state;
            TreeNode node = top.node;
            if (num == 1) {
                pre.add(node.data);
                st.push(new elemStruct(node, 2));
                if (node.left != null) {
                    st.push(new elemStruct(node.left, 1));
                }
            } else if (num == 2) {
                in.add(node.data);
                st.push(new elemStruct(node, 3));
                if (node.right != null) {
                    st.push(new elemStruct(node.right, 1));
                }
            } else {
                post.add(node.data);
            }
        }
        return Arrays.asList(in, pre, post);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        preInPost sol = new preInPost();
        List<List<Integer>> traversals = sol.treeTraversal(root);

        // Print Preorder traversal
        System.out.print("Preorder traversal: ");
        for (int val : traversals.get(0))
            System.out.print(val + " ");
        System.out.println();

        // Print Inorder traversal
        System.out.print("Inorder traversal: ");
        for (int val : traversals.get(1))
            System.out.print(val + " ");
        System.out.println();

        // Print Postorder traversal
        System.out.print("Postorder traversal: ");
        for (int val : traversals.get(2))
            System.out.print(val + " ");
        System.out.println();
    }
}
