class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k > 0; k--) {
            if(i < 0 || j < 0) {
                break;
            } else{
            if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i--];
                } else {
                    nums1[k] = nums2[j--];
                }
            }
        }
        for (int k = 0; k <= j; k++) {
            nums1[k] = nums2[k];
        }
    }
}