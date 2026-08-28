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

public class Codec {

    // Serialize the tree
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();

        serializeHelper(root, result);

        return result.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder result) {

        // Null marker
        if (node == null) {
            result.append("N,");
            return;
        }

        // Root
        result.append(node.val).append(",");

        // Left subtree
        serializeHelper(node.left, result);

        // Right subtree
        serializeHelper(node.right, result);
    }

    // Deserialize the string back into a tree
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));

        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {

        String value = queue.poll();

        
        if (value.equals("N")) {
            return null;
        }

        
        TreeNode node = new TreeNode(Integer.parseInt(value));

        
        node.left = deserializeHelper(queue);

        
        node.right = deserializeHelper(queue);

        return node;
    }
}