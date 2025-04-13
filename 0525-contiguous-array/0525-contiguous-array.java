class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);
        int ans = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curr--;
            } else {
                curr++;
            }
            if (counts.containsKey(curr)) {
                ans = Math.max(ans, i - counts.get(curr));
            } else {
                counts.put(curr, i);
            }
        }
        return ans;
    }
}