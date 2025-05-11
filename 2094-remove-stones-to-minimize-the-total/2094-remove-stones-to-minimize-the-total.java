class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            maxHeap.add(pile);
        }
        for (int i = 0; i < k; i++) {
            int largest = maxHeap.poll();          
            int reduced = largest - largest / 2;    
            maxHeap.add(reduced);                   
        }
        int total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll();
        }
        return total;
    }
}