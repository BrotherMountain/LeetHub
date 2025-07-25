class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int num = matrix[row][col];
            if (num == target) {
                return true;
            }
            if (target > num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}