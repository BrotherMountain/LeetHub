class Solution {
    public int sumOfUnique(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
        count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
        if (count.get(num) < 2) {
            ans += num;
        }
        }
        return ans;
    }
}