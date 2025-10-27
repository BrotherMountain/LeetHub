class Solution {
  public TreeNode balanceBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
  
    return buildTree(0, list.size() - 1, list);
  }

  private TreeNode buildTree(int left, int right, List<Integer> list) {
    if( left > right ) return null;

    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = buildTree(left, mid - 1, list);
    root.right = buildTree(mid + 1, right, list);

    return root;
  }

  private void inOrder(TreeNode root, List<Integer> list) {
    if(root == null){ 
      return;
    }
    
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }
}