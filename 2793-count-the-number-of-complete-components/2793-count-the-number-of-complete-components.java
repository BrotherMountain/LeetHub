class Solution {
  /**
   * 문제 접근: 입력 형식 = 인접 리스트 형태
   */

  public int countCompleteComponents(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] visited = new boolean[n];
    
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }

    // 주어진 간선 정보로 그래프 채우기
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    int ans = 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        //현재 노드 방문했음
        visited[i] = true;

        int nodesCount = 0;
        int edgesCount = 0;

        while (!queue.isEmpty()) {
          int node = queue.remove();
          nodesCount++;
          //간선 수 반환하기
          edgesCount += graph.get(node).size();

          for (int neighbor : graph.get(node)) {
            //연결된 이웃 노드들 탐색하기
            if (!visited[neighbor]) {
              visited[neighbor] = true;
              queue.add(neighbor);
            }
          }
        }

        if (edgesCount / 2 == nodesCount * (nodesCount - 1) / 2) {
          ans++;
        }
      }
    }

    return ans;
  }
}