class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
        return 0;
        }
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < sb.length()) {
        char c = sb.charAt(right);
        if (set.contains(c)) {
            set.remove(sb.charAt(left));
            left++;
        } else {
            set.add(c);
            right++;
            ans = Math.max(ans, right - left);
        }
        }
        return ans;
    }
}