class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean checkOddVal = true;

        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            int beforeVal = checkOddVal ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                int currentVal = node.val;

                if (checkOddVal) {
                    if (currentVal % 2 == 0 || currentVal <= beforeVal) {
                        return false;
                    }
                } else {
                    if (currentVal % 2 == 1 || currentVal >= beforeVal) {
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                beforeVal = currentVal;
            }
            checkOddVal = !checkOddVal;
        }
        return true;
    }
}