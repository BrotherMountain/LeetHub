class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = collectLeaves(root1);
        List<Integer> leaf2 = collectLeaves(root2);
        return leaf1.equals(leaf2);
    }

    private List<Integer> collectLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        if (root == null) return leaves;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            }
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return leaves;
    }
}