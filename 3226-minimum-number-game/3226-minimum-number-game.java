class Solution {
  public int[] numberGame(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.add(num);
    }
    int[] arr = new int[nums.length];
    int i = 0;
    for (int j = 0; j < nums.length/2; j++) {
      int alice = pq.remove();
      int bob = pq.remove();
      arr[i++] = bob;
      arr[i++] = alice;
    }
    return arr;
  }
}