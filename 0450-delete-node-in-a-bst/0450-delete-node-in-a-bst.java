class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode current = root.right;
                while (current.left != null) {
                    current = current.left;
                }
                root.val = current.val;
                root.right = deleteNode(root.right, current.val);
            }
        }
        return root;
    }
}