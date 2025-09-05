class Solution {
  public int[] getFinalState(int[] nums, int k, int multiplier) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.add(num);
    }

    for (int i = 0; i < k; i++) {
      int remove = pq.remove();
      int newValue = remove * multiplier;
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] == remove) {
          nums[j] = newValue;
          break;
        }
      }
      pq.add(newValue);
    }
    return nums;
  }
}