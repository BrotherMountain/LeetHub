class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
      if (a[0] != b[0]) {
        return a[0] - b[0];
      } else {
        return a[1] - b[1];
      }
    });

    for (int i = 0; i < mat.length; i++) {
      int count = 0;
      for (int val : mat[i]) {
        if (val == 1) {
          count++;
        } else {
          break;
        }
      }
      pq.add(new int[]{count, i});
    }

    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      int[] weakestRow = pq.poll();
      ans[i] = weakestRow[1];
    }
    return ans;
  }
}