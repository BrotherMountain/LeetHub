class Solution {
  public int minTimeToReach(int[][] moveTime) {
    int m = moveTime.length;
    int n = moveTime[0].length;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    long[][][] minTime = new long[m][n][2];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Arrays.fill(minTime[i][j], Long.MAX_VALUE);
      }
    }

    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
    minTime[0][0][0] = 0;
    pq.offer(new long[]{0, 0, 0, 1});

    while (!pq.isEmpty()) {
      long[] current = pq.poll();
      long time = current[0];
      int row = (int) current[1];
      int col = (int) current[2];
      int currentMoveCost = (int) current[3];

      if (row == m - 1 && col == n - 1) {
        return (int) time;
      }
      
      int currentCostIndex = (currentMoveCost == 1) ? 0 : 1;
      if (time > minTime[row][col][currentCostIndex]) {
        continue;
      }

      int nextMoveCost = (currentMoveCost == 1) ? 2 : 1;
      int nextCostIndex = (nextMoveCost == 1) ? 0 : 1;

      for (int[] direction : directions) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];

        if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
          
          long startTime = Math.max(time, (long) moveTime[nextRow][nextCol]);

          long arrivalTime = startTime + currentMoveCost;

          if (arrivalTime < minTime[nextRow][nextCol][nextCostIndex]) {
            minTime[nextRow][nextCol][nextCostIndex] = arrivalTime;
            pq.offer(new long[]{arrivalTime, nextRow, nextCol, nextMoveCost});
          }
        }
      }
    }

    return -1;
  }

}