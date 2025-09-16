class Solution {
  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int currentLength = queue.size();
      int val = Integer.MIN_VALUE;
      for (int i = 0; i < currentLength; i++) {
        TreeNode node = queue.remove();
        val = Math.max(val, node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      ans.add(val);
    }
    return ans;
  }
}