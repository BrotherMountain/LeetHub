class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }
        if (elements.size() == 1) {
            return (n * (n + 1)) / 2;
        }
        int ans = 0;

        for (int left = 0; left < n; left++) {
            Set<Integer> count = new HashSet<>();
            for (int right = left; right < n; right++) {
                count.add(nums[right]);
                if (count.size() == elements.size()) {
                    ans++;
                }
            }
        }
        return ans;
    }
}