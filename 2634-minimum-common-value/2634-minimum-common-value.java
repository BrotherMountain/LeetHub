class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
            int point1 = 0, point2 = 0, minValue = -1;
            while (point1 < nums1.length && point2 < nums2.length) {
            if (nums1[point1] < nums2[point2]) {
                point1++;
            } else if (nums1[point1] > nums2[point2]) {
                point2++;
            } else {
                if (minValue == -1) {
                minValue = nums1[point1];
                } else {
                minValue = Math.min(minValue, nums1[point1]);
                }
                point1++;
                point2++;
            }
        }
        return minValue;
    }
}