class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }
        if (k == 1) {
            return right;
        } else if (k == nums.length) {
            return left;
        } else {
            int ans = right;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canSplit(nums, k, mid)) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

    public boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}