class Solution {    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        seen = new boolean[n];
        for (int x : restricted) {
            seen[x] = true;
        }

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
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