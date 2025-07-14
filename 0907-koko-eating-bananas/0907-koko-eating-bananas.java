class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (binarySearch(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean binarySearch(int[] piles, int k,int limit) {
        int hours = 0;

        for (double pile : piles) {
            hours += Math.ceil(pile / k);
        }

        return hours <= limit;
    }
}