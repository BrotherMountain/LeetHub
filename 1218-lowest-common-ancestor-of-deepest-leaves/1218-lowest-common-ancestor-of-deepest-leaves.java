class Solution {
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();

    if(root == null) {
      return null;
    }

    TreeNode a = null;
    TreeNode b = null;

    queue.add(root);
    int currentLvl = 0;
    while(!queue.isEmpty()) {
      int size = queue.size();
      currentLvl++;

      for(int i = 0; i < size;i++) {
        TreeNode temp = queue.poll();

        if(i == 0) {
          a = temp;
        }
        if(i == size - 1) {
          b = temp;
        }
        if(temp.left != null) {
          queue.add(temp.left);
        }
        if(temp.right != null) {
          queue.add(temp.right);
        }
      }
    }

    return lca(root, a, b);
  }

  public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    } else if(root == p) {
      return p;
    } else if(root == q) {
      return q;
    }

    TreeNode lcaOnLeft = lca(root.left, p, q);
    TreeNode lcaOnRight = lca(root.right, p, q);

    if(lcaOnLeft != null && lcaOnRight != null) {
      return root;
    } else if(lcaOnLeft != null) {
      return lcaOnLeft;
    } else if(lcaOnRight != null) {
      return lcaOnRight;
    }

    return null;
  }
}