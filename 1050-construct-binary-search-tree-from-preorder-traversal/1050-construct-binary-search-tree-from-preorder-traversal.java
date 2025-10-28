class Solution {
    private int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {
        if (idx == preorder.length) {
            return null;
        }

        int val = preorder[idx];
        if (val < lower || val > upper) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        
        idx++;
        root.left = build(preorder, lower, val);
        root.right = build(preorder, val, upper);

        return root;
    }
}