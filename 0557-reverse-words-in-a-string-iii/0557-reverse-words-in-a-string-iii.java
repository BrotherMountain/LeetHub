class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = 0; j <= s.length(); j++) {
            if (j == s.length() || s.charAt(j) == ' ') {
                for (int k = j-1; k >= i; k--) {
                sb.append(s.charAt(k));
                }
                if (j < s.length()) {
                sb.append(' ');
                }

                i = j + 1;
            }
        }
        return sb.toString();
    }
}