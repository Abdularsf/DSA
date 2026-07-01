package BinaryTree.Traversal.Inorder;

import java.util.ArrayList;
import java.util.List;

// import javax.swing.tree.TreeNode;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }

}

public class inorderRecursive {
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        helper(root.left, list);
        list.add(root.data);
        helper(root.right, list);
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        inorderRecursive sol = new inorderRecursive();

        List<Integer> result = sol.inorder(root);

        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
