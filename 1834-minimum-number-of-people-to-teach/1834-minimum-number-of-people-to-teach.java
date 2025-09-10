class Solution {
  Map<Integer, Set<Integer>> graph = new HashMap<>();

  public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
    for (int i = 0; i < languages.length; i++) {
      for (int language : languages[i]) {
        if (!graph.containsKey(i + 1)) {
          graph.put(i + 1, new HashSet<>());
        }
        graph.get(i + 1).add(language);
      }
    }

    List<int[]> nonCommunication = new ArrayList<>();
    for (int[] friendship : friendships) {
      int x = friendship[0], y = friendship[1];

      Set<Integer> xSet = graph.get(x);
      Set<Integer> ySet = graph.get(y);

      Set<Integer> intersection = new HashSet<>(xSet);
      intersection.retainAll(ySet);

      if (intersection.isEmpty()) {
        nonCommunication.add(friendship);
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      Set<Integer> count = new HashSet<>();
      for (int[] ints : nonCommunication) {
        int x = ints[0];
        int y = ints[1];

        if (!graph.get(x).contains(i)) {
          count.add(x);
        }

        if (!graph.get(y).contains(i)) {
          count.add(y);
        }
      }
      ans = Math.min(ans, count.size());
    }
    return ans;
  }
}