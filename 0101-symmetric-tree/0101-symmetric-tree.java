class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        preOrder(root.left, left);
        preOrderReverse(root.right, right);
        return left.equals(right);
    }

    public void preOrder(TreeNode node, List<Integer> list) {
        if (node==null) {
            list.add(null);
            return;
        }   
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }


    public void preOrderReverse(TreeNode node, List<Integer> list) {
        if (node==null) {
            list.add(null);
            return;
        }   
        list.add(node.val);
        preOrderReverse(node.right, list);
        preOrderReverse(node.left, list);
    }
}