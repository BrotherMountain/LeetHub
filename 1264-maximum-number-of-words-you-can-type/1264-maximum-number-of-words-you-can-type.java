class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    String[] split = text.split(" ");
    int ans = 0;
    for (String s : split) {
      boolean existed = false;
      for (char c : brokenLetters.toCharArray()) {
        if (s.indexOf(c) != -1) {
          existed = true;
          break;
        }
      }
      if (!existed) {
        ans++;
      }
    }
    return ans;
  }
}