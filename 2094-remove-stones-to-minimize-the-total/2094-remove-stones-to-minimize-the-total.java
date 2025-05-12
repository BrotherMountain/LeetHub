class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            sum += pile;
            heap.offer(pile);
        }

        for (int i = 0; i < k; i++) {
            int remove = heap.remove();
            int floor = (int) Math.floor((double) remove / 2);
            sum -= floor;
            heap.offer(remove-floor);
        }
        return sum;
    }
}