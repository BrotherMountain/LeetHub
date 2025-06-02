class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = root.val;
        int maxLevel = 1;
        int currentLevel = 0;
        int currentSum = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            // 레벨 순회 시작
            currentLevel++;
            int currentLength = queue.size();
            for (int i = 0; i < currentLength; i++) {
                // 값들 다 더하기
                TreeNode node = queue.remove();
                currentSum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //레벨 순회 다 끝난 뒤 비교하기
            if (currentSum > maxSum) {
                maxLevel = currentLevel;
                maxSum = currentSum;
            }
            //레벨 총합 리셋
            currentSum = 0;
        }
        return maxLevel;
    }

}