class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((a, b) -> {
            double dist1 = Math.sqrt(Math.pow(a.get(0), 2) + Math.pow(a.get(1),2));
            double dist2 = Math.sqrt(Math.pow(b.get(0), 2) + Math.pow(b.get(1),2));
            return Double.compare(dist2, dist1);
        });

        for (int[] point : points) {
            heap.offer(List.of(point[0], point[1]));
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            List<Integer> poll = heap.remove();
            ans[i][0] = poll.get(0);
            ans[i][1] = poll.get(1);
        }
        return ans;
    }
}