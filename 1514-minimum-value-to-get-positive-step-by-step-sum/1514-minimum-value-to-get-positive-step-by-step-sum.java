class Solution {
    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length];
        int minValue = nums[0];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
            minValue = Math.min(minValue, prefix[i]);
        }
        return minValue < 1 ? 1 - minValue : 1;
    }
}