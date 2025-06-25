class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
            for (int j : graph[i]) {
                map.get(i).add(j);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph.length - 1, path, ans);
        return ans;
    }

    public void dfs(int node, int target,List<Integer> path, List<List<Integer>> ans) {
        if (node == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (map.get(node) == null) {
            return;
        }

        for (int neighbor : map.get(node)) {
            path.add(neighbor);
            dfs(neighbor, target,path, ans);
            path.remove(path.size() - 1);
        }
    }

}