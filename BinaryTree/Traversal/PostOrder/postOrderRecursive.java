package BinaryTree.Traversal.PostOrder;

import java.util.ArrayList;
import java.util.List;

// import javax.swing.tree.TreeNode;

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

public class postOrderRecursive {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Helper(root, list);
        return list;
    }

    private void Helper(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        Helper(root.left, list);
        Helper(root.right, list);
        list.add(root.data);
    }

    public class Main {
        static void printList(List<Integer> list) {
            // Iterate through the list and print each element
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Creating a sample binary tree
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            postOrderRecursive sol = new postOrderRecursive();
            // Getting postorder traversal
            List<Integer> result = sol.postorder(root);

            // Printing the postorder traversal result
            System.out.print("Postorder traversal: ");
            printList(result);
        }
    }
}
