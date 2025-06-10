class Solution {    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        seen = new boolean[n];
        for (int x : restricted) {
            seen[x] = true;
        }

        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(0);
    }

    public int dfs(int node) {
        seen[node] = true;
        int count = 1;
        for (Integer neighbor : graph.get(node)) {
            if (!seen[neighbor]) {
                count += dfs(neighbor);
            }
        }
        return count;
    }
}