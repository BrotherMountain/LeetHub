public class State {
    public int row;
    public int col;
    public int steps;

    public State(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(entrance[0], entrance[1], 0));
        boolean[][] seen = new boolean[m][n];
        seen[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;

            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1) && !(row == entrance[0] && col == entrance[1])) {
                return steps;
            }

            for (int[] direction : directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (valid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    if (maze[nextRow][nextCol] == '.') {
                        seen[nextRow][nextCol] = true;
                        queue.add(new State(nextRow, nextCol, steps + 1));
                    }
                }
            }
        }
        return -1;
    }

    private boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}