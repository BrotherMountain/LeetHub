class Solution {
  public int makeTheIntegerZero(int num1, int num2) {
    for (int i = 0; i < 60; i++) {
      long target = (long) num1 - (long) i * num2;
      if (Long.bitCount(target) <= i && i <= target) {
        return i;
      }
    }
    return -1;
  }
}