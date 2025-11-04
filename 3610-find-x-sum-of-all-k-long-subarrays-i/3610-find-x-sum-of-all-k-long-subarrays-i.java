class Solution {
  public int[] findXSum(int[] nums, int k, int x) {
    int n = nums.length - k + 1;
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      Map<Integer, Integer> count = new HashMap<>();
      for (int j = i; j < i + k; j++) {
        count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
      }
      if (count.size() < x) {
        for (int j = i; j < i + k; j++) {
          answer[i] += nums[j];
        }
      } else {
        solve(x, i, answer, count);
      }
    }
    return answer;
  }

  private void solve(int x, int index, int[] answer, Map<Integer,Integer> count) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      int freq1 = count.get(o1);
      int freq2 = count.get(o2);
      if (freq1 != freq2) {
        return freq2 - freq1;
      }
      return o2 - o1;
    });

    pq.addAll(count.keySet());

    for (int i = 0; i < x; i++) {
      int remove = pq.remove();
      int freq = count.get(remove);
      answer[index] += remove * freq;
    }
  }
}