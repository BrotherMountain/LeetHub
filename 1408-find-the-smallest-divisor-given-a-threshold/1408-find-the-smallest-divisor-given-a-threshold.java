class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int result = 0;
            for (int num : nums) {
                result += (num + mid - 1)/mid;
            }

            if (result <= threshold) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}