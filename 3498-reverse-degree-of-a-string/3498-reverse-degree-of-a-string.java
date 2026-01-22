class Solution {
  public int reverseDegree(String s) {
    int ans = 0;
    char[] charArray = s.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      ans += (123 - charArray[i]) * (i+1);
    }
    return ans;
  }
}