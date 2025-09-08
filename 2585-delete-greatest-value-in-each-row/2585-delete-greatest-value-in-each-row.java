class Solution {
  public int deleteGreatestValue(int[][] grid) {
    int n = grid[0].length;
    int ans = 0;
    List<PriorityQueue<Integer>> list = new ArrayList<>();
    for (int[] rows : grid) {
      list.add(getQueue(rows));
    }
    while (n > 0) {
      int max = 0;
      for (PriorityQueue<Integer> pq : list) {
        int remove = pq.remove();
        max = Math.max(max, remove);
      }
      ans += max;
      n--;
    }
    return ans;
  }

  private PriorityQueue<Integer> getQueue(int[] rows) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int row : rows) {
      pq.add(row);
    }
    return pq;
  }
}