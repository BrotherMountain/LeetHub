class Solution {
  public int averageOfSubtree(TreeNode root) {
    int[] result = new int[1];
    dfs(root, result);
    return result[0];
  }

  private int[] dfs(TreeNode node, int[] result) {
    if (node == null) {
      return new int[]{0, 0};
    }

    int[] left = dfs(node.left, result);
    int[] right = dfs(node.right, result);

    int sum = node.val + left[0] + right[0];
    int count = 1 + left[1] + right[1];

    if (sum / count == node.val) {
      result[0]++;
    }

    return new int[]{sum, count};
  }
}