class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        while (bfs(dummy.left, dummy, target)) {
        }
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public boolean bfs(TreeNode node, TreeNode parent, int target) {
        if (node == null) {
            return false;
        }

        boolean deleted = false;

        if (node.left == null && node.right == null) {
            if (node.val == target) {
                if (parent.left == node) {
                    parent.left = null;
                } else if (parent.right == node) {
                    parent.right = null;
                }
                return true;
            }
            return false;
        }
        boolean left = bfs(node.left, node, target);
        boolean right = bfs(node.right, node, target);

        return left || right;
    }
}