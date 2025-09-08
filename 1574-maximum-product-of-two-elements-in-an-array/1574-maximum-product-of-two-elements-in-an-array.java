class Solution {
  public int maxProduct(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int num : nums) {
      pq.add(num);
    }
    return (pq.remove() - 1) * (pq.remove() - 1);
  }
}