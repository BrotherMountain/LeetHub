class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // 현재 위치, 이동 횟수
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currPos = curr[0];
            int moves = curr[1];

            if (currPos == n * n) {
                return moves;
            }

            for (int next = currPos + 1; next <= Math.min(currPos + 6, n * n); next++) {
                int[] coords = getCoordinates(next, n);
                int row = coords[0], col = coords[1];

                int finalPos = board[row][col] == -1 ? next : board[row][col];

                if (!visited[finalPos]) {
                    visited[finalPos] = true;
                    queue.offer(new int[]{finalPos, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int curr, int n) {
        int quot = (curr - 1) / n;
        int rem = (curr - 1) % n;
        int row = n - 1 - quot;
        int col = quot % 2 == 0 ? rem : n - 1 - rem;
        return new int[]{row, col};
    }
}