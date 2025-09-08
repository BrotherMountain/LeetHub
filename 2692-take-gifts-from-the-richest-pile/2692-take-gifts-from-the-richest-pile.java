class Solution {
  public long pickGifts(int[] gifts, int k) {
    PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int gift : gifts) {
      pq.add((long)gift);
    }
    for (int i = 0; i < k; i++) {
      Long remove = pq.remove();
      long sqrt = (long) Math.sqrt(remove);
      pq.add(sqrt);
    }
    long ans = 0L;
    while (!pq.isEmpty()) {
      ans += pq.remove();
    }
    return ans;
  }
}