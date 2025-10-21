class Solution {
  public TreeNode bstToGst(TreeNode root) {
    dfs(root, 0);
    return root;
  }

  private int dfs(TreeNode node, int val) {
    if (node == null) {
      return val;
    }

    int right = dfs(node.right, val);
    node.val = node.val + right;
    return dfs(node.left, node.val);
  }
}