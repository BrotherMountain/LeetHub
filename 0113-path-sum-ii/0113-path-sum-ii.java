class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), 0, targetSum, ans);
        return ans;
    }

    private static void dfs(TreeNode node, List<Integer> path, int sum, int target, List<List<Integer>> ans) {
        if (node == null) return;

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, path, sum, target, ans);
            dfs(node.right, path, sum, target, ans);
        }

        path.remove(path.size() - 1);
    }
}