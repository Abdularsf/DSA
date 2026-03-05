package BinaryTree.Preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrderIterative {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (st.isEmpty() == false) {
            TreeNode node = st.pop();
            list.add(node.data);
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        preOrderRecursive solution = new preOrderRecursive();
        List<Integer> result = solution.preorder(root);
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
