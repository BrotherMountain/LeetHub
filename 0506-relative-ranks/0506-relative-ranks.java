class Solution {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < n; i++) {
      pq.add(score[i]);
      map.put(score[i], i);
    }
    String[] ans = new String[n];

    for (int i = 0; i < n; i++) {
      int remove = pq.remove();
      int index = map.get(remove);
      if (i == 0) {
        ans[index] = "Gold Medal";
      } else if (i == 1) {
        ans[index] = "Silver Medal";
      } else if (i == 2) {
        ans[index] = "Bronze Medal";
      } else {
        String medal = String.valueOf(i+1);
        ans[index] = medal;
      }
    }
    return ans;
  }
}