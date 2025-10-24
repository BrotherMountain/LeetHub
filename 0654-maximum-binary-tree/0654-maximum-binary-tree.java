class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return build(nums,0,nums.length-1);
    }

    private TreeNode build(int nums[] , int start , int end){
        if(start > end){ 
            return null;
        }

        int idx = start;
        for(int i = start; i<=end; i++){
            if(nums[i] > nums[idx]){
                idx = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idx]);
        
        root.left = build(nums, start , idx-1);
        root.right = build(nums ,idx+1 , end);
        
        return root;
    }
}