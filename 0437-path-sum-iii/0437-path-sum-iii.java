
class Solution {
    Map<Long, Integer> count = new HashMap<>();
    long target;
    int totalPaths = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        count.put(0L, 1);
        dfs(root, 0L);
        return totalPaths;
    }

    private void dfs(TreeNode node, long  curr) {
        if (node == null) return;

        curr += node.val;

        totalPaths += count.getOrDefault(curr - target, 0);

        count.put(curr, count.getOrDefault(curr, 0) + 1);

        dfs(node.left, curr);
        dfs(node.right, curr);

        count.put(curr, count.get(curr) - 1);
    }
}