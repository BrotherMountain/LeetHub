class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            double sum = 0;
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(sum / currentLength);
        }
        return ans;
    }
}