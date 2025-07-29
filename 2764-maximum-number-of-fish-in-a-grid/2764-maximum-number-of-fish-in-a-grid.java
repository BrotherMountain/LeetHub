class Solution {
    int m;
    int n;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] seen;
    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        int ans = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] > 0 && !seen[row][col]) {
                    seen[row][col] = true;
                    int fish = dfs(row, col, grid);
                    ans = Math.max(ans, fish);
                }
            }
        }
        return ans;
    }

    private boolean valid(int row, int col, int[][] grid) {
        return 0<= row && row < m && 0 <= col && col < n && grid[row][col] > 0;
    }

    public int dfs(int row, int col, int[][] grid) {
        int current = grid[row][col];
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (valid(nextRow,nextCol,grid) && !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                current += dfs(nextRow, nextCol, grid);
            }
        }
        return current;
    }
}