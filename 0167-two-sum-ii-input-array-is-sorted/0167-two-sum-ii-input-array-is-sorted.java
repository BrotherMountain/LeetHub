class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        int[] ans = new int[2];
        while (i < numbers.length && j >= 0) {
            if (numbers[i] + numbers[j] == target) {
                ans = new int[]{i + 1, j + 1};
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            } 
        }
        return ans;
    }
}