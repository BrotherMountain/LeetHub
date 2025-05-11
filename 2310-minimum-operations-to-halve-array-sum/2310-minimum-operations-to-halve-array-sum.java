class Solution {
    public int halveArray(int[] nums) {
        double target = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (double num : nums) {
            target += num;
            pq.offer(num);
        }
        double half = target / 2;
        int ans = 0;
        while (target > half) {
            double x = pq.remove();
            target -= (x / 2);
            pq.add(x / 2);
            ans++;
        }
        return ans;
    }
}