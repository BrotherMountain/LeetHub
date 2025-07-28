class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] seen;

    public int closedIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0 && !seen[row][col]) {
                    if (dfs(row, col, grid)) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }


    public boolean dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }

        if (grid[row][col] == 1 || seen[row][col]) {
            return true;
        }
        seen[row][col] = true;

        boolean isClosed = true;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (!dfs(nextRow, nextCol, grid)) {
                isClosed = false;
            }
        }
        return isClosed;
    }
}