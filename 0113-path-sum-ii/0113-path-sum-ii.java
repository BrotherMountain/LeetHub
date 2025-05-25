class Solution {
    static List<List<Integer>> ans;
    static int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        target = targetSum;
        dfs(root, new ArrayList<>(), 0);
        return ans;
    }

    private static void dfs(TreeNode node, List<Integer> path, int sum) {
        if (node == null) return;

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, path, sum);
            dfs(node.right, path, sum);
        }

        path.remove(path.size() - 1);
    }
}