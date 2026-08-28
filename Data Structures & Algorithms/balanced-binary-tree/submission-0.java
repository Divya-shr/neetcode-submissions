/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        // Empty tree has height 0
        if (node == null) {
            return 0;
        }

        // Get left subtree height
        int leftHeight = dfs(node.left);

        // If left subtree is unbalanced
        if (leftHeight == -1) {
            return -1;
        }

        // Get right subtree height
        int rightHeight = dfs(node.right);

        // If right subtree is unbalanced
        if (rightHeight == -1) {
            return -1;
        }

        // Current node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}