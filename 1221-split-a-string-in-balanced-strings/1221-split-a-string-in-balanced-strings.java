class Solution {
  public int balancedStringSplit(String s) {
    char[] charArray = s.toCharArray();
    int ans = 0;
    int count = 0;
    for (char c : charArray) {
      if (c == 'R') {
        count++;
      } else {
        count--;
      }
      if (count == 0) {
        ans++;
      }
    }
    return ans;
  }
}