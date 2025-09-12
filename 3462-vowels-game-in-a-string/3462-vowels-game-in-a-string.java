class Solution {
  private boolean isVowel(char c) {
    return "aeiou".indexOf(c) != -1;
  }

  public boolean doesAliceWin(String s) {
    int vowels = 0;
    for (char c : s.toCharArray()) {
      if (isVowel(c)) {
        vowels++;
      }
    }
    if (vowels == 0) {
      return false;
    } else {
      return true;
    }
  }
}