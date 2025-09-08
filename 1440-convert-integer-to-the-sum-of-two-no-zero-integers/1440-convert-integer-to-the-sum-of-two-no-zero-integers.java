class Solution {
  public int[] getNoZeroIntegers(int n) {
    int a = findA(n-1, 1);
    return new int[]{a, n - a};
  }

  private int findA(int n, int a) {
    char[] c1 = String.valueOf(n).toCharArray();
    for (char c : c1) {
      if (c == '0') {
        return findA(n - 1, a + 1);
      }
    }
    char[] c2 = String.valueOf(a).toCharArray();
    for (char c : c2) {
      if (c == '0') {
        return findA(n - 1, a + 1);
      }
    }
    return a;
  }
}