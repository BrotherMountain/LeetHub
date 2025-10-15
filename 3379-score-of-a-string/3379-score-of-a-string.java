class Solution {
  public int scoreOfString(String s) {
    int ans = 0;
    char[] charArray = s.toCharArray();
    for (int i = 1; i < s.length(); i++) {
      int value = Math.abs(charArray[i] - charArray[i - 1]);
      ans += value;
    }
    return ans;
  }
}