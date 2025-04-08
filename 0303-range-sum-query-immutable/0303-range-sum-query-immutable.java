class NumArray {
    private int[] array;

    public NumArray(int[] nums) {
        array = nums;
    }

    public int sumRange(int left, int right) {
        int ans = 0;
        for (; left<= right; left++) {
            ans += array[left];
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */