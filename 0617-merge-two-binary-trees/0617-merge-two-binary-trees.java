/**
    접근 방식: DFS 방식으로 깊게 깊게 내려가면서 양쪽 자식이 둘 다 없으면 null 반환, 한쪽만 있으면 있는 쪽 반환
    둘 다 있으면 값 둘다 합치기
    양쪽 자식의 결과가 먼저 필요하므로 후위순회

 */
class Solution {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    }
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    TreeNode root = new TreeNode(root1.val + root2.val);
    root.left = mergeTrees(root1.left, root2.left);
    root.right = mergeTrees(root1.right, root2.right);
    return root;
  }
}