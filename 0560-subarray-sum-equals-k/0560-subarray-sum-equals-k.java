class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int curr = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
}