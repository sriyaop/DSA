import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LargestBSTInBT {

    // Helper class to store info for each subtree
    static class NodeInfo {
        boolean isBST;
        int size, min, max;

        NodeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBSTSize = 0;

    public static int largestBSTSubtree(TreeNode root) {
        maxBSTSize = 0;  // Reset before each call
        postOrder(root);
        return maxBSTSize;
    }

    private static NodeInfo postOrder(TreeNode node) {
        if (node == null)
            return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        NodeInfo left = postOrder(node.left);
        NodeInfo right = postOrder(node.right);

        // Check if the current node forms a BST with its subtrees
        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxBSTSize = Math.max(maxBSTSize, size);
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);
            return new NodeInfo(true, size, min, max);
        }

        return new NodeInfo(false, 0, 0, 0);  // Not a BST
    }

    // Driver code to test
    public static void main(String[] args) {
        /*
              10
             /  \
            5   15
           / \    \
          1   8    7
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        int result = largestBSTSubtree(root);
        System.out.println("Size of the largest BST is: " + result);
    }
}
