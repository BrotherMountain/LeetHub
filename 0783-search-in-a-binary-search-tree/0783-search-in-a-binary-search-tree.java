class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val == root.val) {
            return root;
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}