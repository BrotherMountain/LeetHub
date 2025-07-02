class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo.containsKey(amount)) return memo.get(amount);

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        int result = (min == Integer.MAX_VALUE) ? -1 : min;
        memo.put(amount, result);
        return result;
    }
}