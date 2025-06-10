class Solution {        
    int m,n,max;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        max = 0;
        seen = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 && !seen[row][col]) {
                    int area = dfs(row, col, grid);
                    max = Math.max(max,area );
                }
            }
        }
        return max;
    }

    public int dfs(int row, int col, int[][] grid) {
        seen[row][col] = true;
        int area = 1;
        for (int[] direction : directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                area += dfs(nextRow, nextCol, grid);
            }
        }
        return area;
    }

    private boolean valid(int row, int col, int[][] grid) {
        return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == 1;
    }
}