class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, ans = 0, curr = 0;
        for (int right = 0; right < s.length(); right++) {
            curr += Math.abs(s.charAt(right) - t.charAt(right));
            while (curr > maxCost) {
                curr -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}