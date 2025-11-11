class Solution {
  public List<List<Integer>> getAncestors(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<List<Integer>> answer = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
      answer.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      graph.get(u).add(v);
    }
    for (int i = 0; i < n; i++) {
      boolean[] visit = new boolean[n];
      dfs(graph, answer, visit, i, i);
    }
    for (int i = 0; i < n; i++) {
      answer.get(i).sort(Integer::compareTo);
    }

    return answer;
  }

  private void dfs(Map<Integer, List<Integer>> graph, List<List<Integer>> answer,boolean[] visit, int parent, int curr) {
    visit[curr] = true;
    for (int neighbor : graph.get(curr)) {
      if (!visit[neighbor]) {
        answer.get(neighbor).add(parent);
        dfs(graph, answer, visit, parent, neighbor);
      }
    }
  }
}