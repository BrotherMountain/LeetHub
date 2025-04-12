class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums) {
            for (int i : num) {
                    map.put(i, map.getOrDefault(i,0) + 1);
                }
            }
        int n = nums.length;
        for (Integer i : map.keySet()) {
            if (map.get(i) == n) {
                ans.add(i);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}