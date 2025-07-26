class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() == k) {
            return true;
        } else if (s.length() < k) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int oddCount = 0;
        for (Integer value : count.values()) {
            if (value % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}