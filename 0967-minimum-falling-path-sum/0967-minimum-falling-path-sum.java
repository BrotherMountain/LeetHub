class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] dp = new int[m][m];

        for (int col = 0; col < m; col++) {
            dp[0][col] = matrix[0][col];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < m; col++) {
                int minAbove = dp[row - 1][col];
                if (col > 0) {
                    minAbove = Math.min(minAbove, dp[row - 1][col - 1]);
                }
                if (m > col + 1) {
                    minAbove = Math.min(minAbove, dp[row - 1][col + 1]);
                }
                dp[row][col] = matrix[row][col] + minAbove;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int col = 0; col < m; col++) {
            result = Math.min(result, dp[m - 1][col]);

        }
        return result;
    }
}