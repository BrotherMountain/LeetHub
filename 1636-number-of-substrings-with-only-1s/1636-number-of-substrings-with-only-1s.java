class Solution {
  public int numSub(String s) {
    int mod=(int)1e9+7;
    int n = s.length();
    long totalCount = 0, currCount = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '1') {
        currCount = (currCount + 1) % mod;
      } else {
        currCount = 0;
      }
      totalCount = (totalCount + currCount) % mod;
    }
    return (int) totalCount;
  }
}