class Solution {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return max;
    }

    public void dfs(TreeNode node, int count, boolean searchLeft) {
        if (node == null) {
            return;
        }
        max = Math.max(max, count);

        if (searchLeft) {
            dfs(node.right, count + 1, false);
            dfs(node.left, 1, true);
        } else {
            dfs(node.left, count + 1, true);
            dfs(node.right, 1, false);
        }
    }
}