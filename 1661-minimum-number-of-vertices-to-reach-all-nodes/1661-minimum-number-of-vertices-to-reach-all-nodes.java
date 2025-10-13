class Solution {
  // 문제 접근: 가장 작은 정점들의 집합
  // 입력 형식 = 인접 리스트
  // 들어오는 노드가 0인것만 세면 됨
  // 들어오는 노드를 Set 구조에 집어넣고 n까지 값 중에서 없는 값이 정답
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    for (List<Integer> edge : edges) {
      int x = edge.get(0), y = edge.get(1);
      if (!graph.containsKey(x)) {
        graph.put(x, new ArrayList<>());
      }
      graph.get(x).add(y);
    }

    List<Integer> ans = new ArrayList<>();

    for (int i : graph.keySet()) {
      List<Integer> nodes = graph.get(i);
      set.addAll(nodes);
    }

    for (int i = 0; i < n; i++) {
      if (!set.contains(i)) {
        ans.add(i);
      }
    }

    return ans;
  }
}