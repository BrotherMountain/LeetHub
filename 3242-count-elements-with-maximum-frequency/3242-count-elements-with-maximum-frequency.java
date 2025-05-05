class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        int maxFreq = 0;
        for (int value : count.values()) {
            maxFreq = Math.max(maxFreq, value);
        }
        for (int value : count.values()) {
            if (value == maxFreq) {
                ans += value;
            }
        }
        return ans;
    }
}