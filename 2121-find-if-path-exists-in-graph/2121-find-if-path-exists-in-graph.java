class Solution {    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        return dfs(source, destination);
    }

    public boolean dfs(int curr, int dest) {
        if (curr == dest) return true;
        if (!seen.contains(curr)) {
            seen.add(curr);
            for (Integer neighbor : graph.get(curr)) {
                if (dfs(neighbor, dest)) {
                    return true;
                }
            }
        }
        return false;
    }
}