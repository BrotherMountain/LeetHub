class Solution {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    int[] states = new int[n];
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (isSafe(i, graph, states)) {
        ans.add(i);
      }
    }
    return ans;
  }

  private boolean isSafe(int node, int[][] graph, int[] states) {
    if (states[node] != 0) {
      return states[node] == 2;
    }

    states[node] = 1;

    for (int neighbor : graph[node]) {
      if (!isSafe(neighbor, graph, states)) {
        return false;
      }
    }

    states[node] = 2;
    return true;
  }
}