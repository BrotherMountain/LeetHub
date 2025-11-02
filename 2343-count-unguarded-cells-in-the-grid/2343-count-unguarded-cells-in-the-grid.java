class Solution {

  Map<String, Boolean> map = new HashMap<>();
  int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  boolean[][] visited;

  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    visited = new boolean[m][n];
    for (int[] wall : walls) {
      int x = wall[0];
      int y = wall[1];
      map.put(x + "," + y, true);
      visited[x][y] = true;
    }
    for (int[] guard : guards) {
      int x = guard[0];
      int y = guard[1];
      map.put(x + "," + y, true);
      visited[x][y] = true;
    }

    for (int[] guard : guards) {
      int x = guard[0];
      int y = guard[1];
      bfs(m, n, x, y);
    }

    int ans = 0;
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (!visited[row][col]) {
          ans++;
        }
      }
    }
    return ans;
  }

  private void bfs(int m, int n, int x, int y) {
    for (int[] direction : directions) {
      int nextRow = x + direction[0];
      int nextCol = y + direction[1];

      while (helper(nextRow, nextCol, m, n)) {
        if (map.containsKey(nextRow + "," + nextCol)) {
          break;
        }
        visited[nextRow][nextCol] = true;
        nextRow += direction[0];
        nextCol += direction[1];
      }
    }
  }

  private boolean helper(int nextRow, int nextCol, int m, int n) {
    return nextRow < m && nextCol < n && nextRow >= 0 && nextCol >= 0;
  }
}