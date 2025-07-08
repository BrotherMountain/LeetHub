class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int hold = -prices[0];
        int cash = 0;
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevCash = cash;
            int prevCooldown = cooldown;

            hold = Math.max(prevHold, prevCash - prices[i]);
            cash = Math.max(prevCash, prevCooldown);

            cooldown = prevHold + prices[i];
        }
        return Math.max(cash, cooldown);
    }
}