public class Solution {
    public int maximumLength(int[] nums) {
        int oddCount = 0, evenCount = 0;
        for (int x : nums) {
            if ((x & 1) == 0) evenCount++;
            else               oddCount++;
        }
        int len0 = Math.max(oddCount, evenCount);

        int altLen = 0;
        int last = -1;
        for (int x : nums) {
            int p = x & 1;
            if (last == -1 || p != last) {
                altLen++;
                last = p;
            }
        }

        return Math.max(len0, altLen);
    }
}