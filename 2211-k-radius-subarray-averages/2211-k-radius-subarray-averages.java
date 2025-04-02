class Solution {
    public int[] getAverages(int[] nums, int k) {
        int center = k, left = 0, right = 0;
        long sum = 0;
        int[] ansArray = new int[nums.length];
        Arrays.fill(ansArray, -1);
        if (k == 0) {
            return nums;
        }
        if (2 * k + 1 > nums.length) {
            return ansArray;
        }

        for (; right < 2 * k + 1; right++) {
            sum += nums[right];
        }
        ansArray[center++] = (int) (sum / (2 * k + 1));

        while (right < nums.length) {
            sum += nums[right++] - nums[left++];

            if (center < nums.length) {
                ansArray[center++] = (int)  (sum / (2 * k + 1));
            }
        }

        return ansArray;
    }
}