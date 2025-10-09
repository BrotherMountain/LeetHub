//15분 문제 풀이 실패
//
class Solution {
  public int sumEvenGrandparent(TreeNode root) {
    return solve(root, -1, -1);
  }

  private int solve(TreeNode root, int parent, int gParent) {
    if (root == null) {
      return 0;
    }

    // 후위 순회 방식
    // root 기준 왼쪽 자식들의 조부모 짝수 값 반환
    int left = solve(root.left, root.val, parent);
    // root 기준 오른쪽 자식들의 조부모 짝수 값 반환
    int right = solve(root.right, root.val, parent);
    // root 본인의 값 반환
    return left + right +(gParent % 2 == 0 ? root.val : 0);
  }
}