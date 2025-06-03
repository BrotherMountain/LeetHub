class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new LinkedList<>();
        dfs(root1,ans);
        dfs(root2,ans);
        Collections.sort(ans);
        return ans;
    }

    public static void dfs(TreeNode node1, List<Integer> ans) {
        if (node1 == null) return;
        dfs(node1.left, ans);
        ans.add(node1.val);
        dfs(node1.right, ans);
    }
}