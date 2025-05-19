class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int prev = 0;
            int currentLength = queue.size();
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                prev += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans = prev;
        }
        return ans;
    }
}