class Solution {
  public int minimumOperations(int[] nums) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
      if (num > 0) {
        pq.add(num);
      }
    }
    int ans = 0;
    while(!pq.isEmpty()){
	    int smallest = pq.poll();
	    ans++;
	    while(!pq.isEmpty() && pq.peek() == smallest){
		    pq.poll();
	    }
    }
    return ans;
  }
}