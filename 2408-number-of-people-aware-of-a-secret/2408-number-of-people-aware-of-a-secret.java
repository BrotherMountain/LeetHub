class Solution {
  public int peopleAwareOfSecret(int n, int delay, int forget) {
    final int MOD = 1_000_000_007;
    long[] dp = new long[n + 1];

    dp[1] = 1;

    long sharingCount = 0;

    for (int i = 2; i <= n; i++) {
      int newSharerDay = i - delay;
      if (newSharerDay > 0) {
        sharingCount = (sharingCount + dp[newSharerDay]) % MOD;
      }
      int forgetDay = i - forget;
      if (forgetDay > 0) {
        sharingCount = (sharingCount - dp[forgetDay] + MOD) % MOD;
      }

      dp[i] = sharingCount;
    }
    long totalKnown = 0;
    for (int i = n - forget + 1; i <= n; i++) {
      if (i > 0) {
        totalKnown = (totalKnown + dp[i]) % MOD;
      }
    }

    return (int) totalKnown;
  }
}