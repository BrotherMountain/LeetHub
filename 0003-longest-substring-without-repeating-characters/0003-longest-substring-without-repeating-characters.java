class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int ans = 0;
        
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (counts.containsKey(c) && counts.get(c) >= left) {
            left = counts.get(c) + 1;
        }
        counts.put(c, right);
        ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}