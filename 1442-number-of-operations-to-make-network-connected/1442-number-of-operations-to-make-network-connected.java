class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] isVisit = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                dfs(i, graph, isVisit);
                ans += 1;
            }
        }
        return ans - 1;
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] isVisit) {
        isVisit[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!isVisit[neighbor]) {
                dfs(neighbor, graph, isVisit);
            }
        }
    }
}