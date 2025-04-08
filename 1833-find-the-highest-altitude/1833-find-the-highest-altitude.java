class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int[] prefix = new int[gain.length + 1];
        prefix[0] = 0;

        for (int i = 1; i <= gain.length; i++) {
            prefix[i] = prefix[i - 1]+ gain[i-1];
            ans = Math.max(ans, prefix[i]);
        }
        return ans;
    }
}