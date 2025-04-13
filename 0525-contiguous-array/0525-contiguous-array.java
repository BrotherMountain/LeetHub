class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (counts.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - counts.get(sum));
            } else {
                counts.put(sum, i);
            }
        }

        return maxLength;
    }
}