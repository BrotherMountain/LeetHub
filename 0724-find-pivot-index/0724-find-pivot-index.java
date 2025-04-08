class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = prefix[nums.length - 1] - leftSum - nums[i];
            if (rightSum==leftSum) {
                return i;
            }
            leftSum = prefix[i];
        }
        return -1;
    }
}