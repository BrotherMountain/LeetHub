class Solution {
  public int numRookCaptures(char[][] board) {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[] rook = new int[2];
    Set<String> pawn = new HashSet<>();
    Set<String> bishops = new HashSet<>();
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        char unit = board[row][col];
        if (unit == 'R') {
          rook = new int[]{row, col};
        }
        if (unit == 'p') {
          pawn.add(row + "," + col);
        }
        if (unit == 'B') {
          bishops.add(row + "," + col);
        }
      }
    }
    int ans = 0;
    for (int[] direction : directions) {
      int nextRow = rook[0] + direction[0];
      int nextCol = rook[1] + direction[1];
      while (nextRow >= 0 && nextCol >= 0 && nextRow < 8 && nextCol < 8) {
        String currentPos = nextRow + "," + nextCol;
        if (bishops.contains(currentPos)) {
          break;
        }
        if (pawn.contains(currentPos)) {
          ans++;
          break;
        }
        nextRow += direction[0];
        nextCol += direction[1];
      }
    }
    return ans;
  }
}