class Solution {
  public int minimumOperations(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      if (num > 0) {
        pq.add(num);
      }
    }
    int ans = 0;
    while (!pq.isEmpty()) {
      PriorityQueue<Integer> temp = new PriorityQueue<>();
      int remove = pq.remove();
      while (!pq.isEmpty()) {
        int remove1 = pq.remove();
        int val = remove1 - remove;
        if (val > 0) {
          temp.add(val);
        }
      }
      pq = temp;
      ans++;
    }
    return ans;
  }
}