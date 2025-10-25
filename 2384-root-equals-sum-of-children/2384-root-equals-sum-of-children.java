class Solution {
  public boolean checkTree(TreeNode root) {
    int dfs = dfs(root);
    return dfs != Integer.MIN_VALUE;
  }

  private int dfs(TreeNode node) {
    if (node.left == null && node.right == null) {
      return node.val;
    }
    int left = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;
    
    if (node.left != null) {
      left = dfs(node.left);
    }

    if (node.right != null) {
      right = dfs(node.right);
    }

    return node.val == left + right ? node.val : Integer.MIN_VALUE;
  }

}