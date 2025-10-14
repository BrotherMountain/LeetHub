class Solution {
  public int findChampion(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    for (int[] edge : edges) {
      int x = edge[0], y = edge[1];
      if (!graph.containsKey(x)) {
        graph.put(x, new ArrayList<>());
      }
      graph.get(x).add(y);
    }

    int ans = -1;
    for (int i : graph.keySet()) {
      List<Integer> nodes = graph.get(i);
      set.addAll(nodes);
    }

    if (set.size() == n - 1) {
      for (int i = 0; i < n; i++) {
        if (!set.contains(i)) {
          ans = i;
        }
      }
    } else {
      return -1;
    }
    return ans;
  }
}