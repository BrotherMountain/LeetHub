/**
    트리를 받으면 일단 DFS 방식으로 접근해서 트리를 원상태로 돌리기
    
 */
class FindElements {
  TreeNode treeNode = null;

  public FindElements(TreeNode root) {
    if (root != null && root.val == -1) {
      root.val = 0;
    }
    dfsForRecover(root);
    treeNode = root;
  }

  public boolean find(int target) {
    TreeNode node = new TreeNode();
    node = treeNode;
    return dfs(node, target);
  }

  private void dfsForRecover(TreeNode node) {
    if (node == null) {
      return;
    }
    if (node.left != null) {
      node.left.val = 2 * node.val + 1;
    }
    if (node.right != null) {
      node.right.val = 2 * node.val + 2;
    }
    dfsForRecover(node.left);
    dfsForRecover(node.right);
  }

  private boolean dfs(TreeNode node, int target) {
    if (node == null) {
      return false;
    }
    if (node.val == target) {
      return true;
    }
    return dfs(node.left, target) || dfs(node.right, target);
  }
}