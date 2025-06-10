class Solution {    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return dfs(source, destination);
    }

    public boolean dfs(int curr, int dest) {
        if (curr == dest) return true;
        if (seen.contains(curr)) return false;
        seen.add(curr);
        for (Integer neighbor : graph.get(curr)) {
            if (dfs(neighbor, dest)) {
                return true;
            }
        }
        return false;
    }
}