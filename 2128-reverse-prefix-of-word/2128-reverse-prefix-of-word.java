class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int idx = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return word;
        }

        for (int i = idx; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        for (int i = idx + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}