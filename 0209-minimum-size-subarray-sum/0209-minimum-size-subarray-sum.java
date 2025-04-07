class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int curr = 0;
        int ans = nums.length + 1;
        for (; right < nums.length; right++) {
            curr += nums[right];
            while (curr >= target) {
                ans = Math.min(ans, right - left + 1);
                curr -= nums[left++];
            }
        }
        if (ans == nums.length + 1) {
            return 0;
        } else {
            return ans;
        }
    }
}