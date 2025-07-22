class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count1 = new HashMap<>();
        Map<String, Integer> count2 = new HashMap<>();

        for (String s : words1) {
            count1.put(s, count1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            count2.put(s, count2.getOrDefault(s, 0) + 1);
        }
        int ans = 0;
        for (String s : count1.keySet()) {
            if (count1.get(s) == 1) {
                if (count2.get(s) != null && count2.get(s) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}