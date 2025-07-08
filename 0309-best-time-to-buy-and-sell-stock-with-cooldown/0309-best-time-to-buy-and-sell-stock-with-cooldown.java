class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int hold = -prices[0];
        int cash = 0;
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, cooldown);
            cooldown = hold + prices[i];
        }
        return Math.max(cash, cooldown);
    }
}