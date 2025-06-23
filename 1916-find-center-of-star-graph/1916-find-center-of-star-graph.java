class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;

    public int findCenter(int[][] edges) {
        seen = new boolean[edges.length + 1];
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int center = 1;
        for (int[] edge : edges) {
            if (graph.get(edge[0]).size() >= graph.get(center).size()) {
                center = edge[0];
            }
            if (graph.get(edge[1]).size() >= graph.get(center).size()) {
                center = edge[1];
            }
        }
        return center;
    }
}