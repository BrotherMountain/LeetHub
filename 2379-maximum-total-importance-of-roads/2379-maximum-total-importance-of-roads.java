class Solution {
   public long maximumImportance(int n, int[][] roads) {
    int[] degree = new int[n];
    for (int[] road : roads) {
      degree[road[0]]++;
      degree[road[1]]++;
    }
    List<Integer> cities = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      cities.add(i);
    }
    
    cities.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(degree[o2], degree[o1]);
      }
    });

    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += (long) (n - i) * degree[cities.get(i)];
    }
    
    return ans;
  }
}