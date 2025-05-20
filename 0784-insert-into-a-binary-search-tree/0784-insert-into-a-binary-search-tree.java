class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        TreeNode parent = root;
        TreeNode current = root;

        while (parent != null) {
            parent = current;
            if (parent.val > node.val) {
                current = parent.left;
                if (current == null) {
                    parent.left = node;
                    return root;
                }
            } else {
                current = parent.right;
                if (current == null) {
                    parent.right = node;
                    return root;
                }
            }
        }
        return root;
    }
}