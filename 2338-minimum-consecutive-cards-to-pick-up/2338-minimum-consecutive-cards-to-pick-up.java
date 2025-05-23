class Solution {
    public int minimumCardPickup(int[] cards) {
                Map<Integer, Integer> dic = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (dic.containsKey(num)) {
                ans = Math.min(ans, i - dic.get(num) + 1);
            }
            dic.put(num, i);
        }
        
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        
        return ans;
    }
}