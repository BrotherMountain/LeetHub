class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0]; // 첫날 주식을 삼
        int cash = 0; // 첫날 주식을 안 삼

        for (int i = 1; i < n; i++) {
            //다음 날
            //주식을 매수 했을 때, 넘겼을 때를 비교,
            //가장 큰 이득을 얻은 경우에만 hold에 값 넣기
            hold = Math.max(hold, cash - prices[i]);
            //주식을 매도 했을 때, 넘겼을 때를 비교
            //가장 큰 이득을 얻는 경우에만 cash에 값 넣기
            cash = Math.max(cash, hold + prices[i] - fee);
        }
        return cash;
    }
}