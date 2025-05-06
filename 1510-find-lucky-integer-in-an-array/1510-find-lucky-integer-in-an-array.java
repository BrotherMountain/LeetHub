class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        int ans = -1;
        for (int i : arr) {
            int freq = count.get(i);
            if (freq == i) {
              ans = Math.max(ans, freq);
            }
        }
        return ans;
    }
}