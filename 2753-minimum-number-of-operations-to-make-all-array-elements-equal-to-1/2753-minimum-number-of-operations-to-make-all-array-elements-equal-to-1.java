class Solution {
  public int minOperations(int[] nums) {
    int n = nums.length;
    int one = 0;
    int g = 0;
    for (int num : nums) {
      if (num == 1) {
        one++;
      }
      g = gcd(g, num);
    }
    if (one > 0) {
      return n - one;
    }
    if (g > 1) {
      return -1;
    }

    int minLen = n;
    for (int i = 0; i < n; i++) {
      int currentGcd = 0;
      for (int j = i; j < n; j++) {
        currentGcd = gcd(currentGcd, nums[j]);
        if (currentGcd == 1) {
          minLen = Math.min(minLen, j - i + 1);
          break;
        }
      }
    }
    return minLen + n - 2;
  }

  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}