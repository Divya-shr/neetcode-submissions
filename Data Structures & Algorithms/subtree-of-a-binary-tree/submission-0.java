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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If we've reached the end of root,
        // there is no subtree to compare.
        if (root == null) {
            return false;
        }

        // Check if trees starting at these nodes are identical
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search in left or right subtree
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {

        // Both are null
        if (p == null && q == null) {
            return true;
        }

        // One is null
        if (p == null || q == null) {
            return false;
        }

        // Values don't match
        if (p.val != q.val) {
            return false;
        }

        // Both subtrees must match
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}