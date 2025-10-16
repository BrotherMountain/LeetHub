class Solution {
  public int findSmallestInteger(int[] nums, int value) {
    int[] counts = new int[value];
    for (int num : nums) {
      int remainder = (num % value + value) % value;
      counts[remainder]++;
    }
    int ans = 0;
    while (true) {
      int requiredRemainder = ans % value;
      if (counts[requiredRemainder] > 0) {
        counts[requiredRemainder]--;
        ans++;
      } else {
        break;
      }
    }
    return ans;
  }
}