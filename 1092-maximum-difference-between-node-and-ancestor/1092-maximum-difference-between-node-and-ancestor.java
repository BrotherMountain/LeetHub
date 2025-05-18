
class Solution {
     int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    public  void dfs(TreeNode node, int maxVal, int minVal) {
        if (node == null) return;

        int diff = Math.max(Math.abs(maxVal - node.val), Math.abs(minVal - node.val));
        maxDiff = Math.max(maxDiff, diff);

        dfs(node.left, Math.max(maxVal, node.val), Math.min(minVal, node.val));
        dfs(node.right, Math.max(maxVal, node.val), Math.min(minVal, node.val));
    }
    
}