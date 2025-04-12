class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> winnerCounts = new HashSet<>();
        HashMap<Integer, Integer> loserCounts = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] match : matches) {
            winnerCounts.add(match[0]);
            loserCounts.put(match[1], loserCounts.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> loser = new ArrayList<>();
        for (int[] match : matches) {
            if (loserCounts.containsKey(match[1])) {
                if (loserCounts.get(match[1]) == 1) {
                    loser.add(match[1]);
                    winnerCounts.remove(match[1]);
                } else if (loserCounts.get(match[1]) >= 2) {
                    winnerCounts.remove(match[1]);
                }
            }
        }
        List<Integer> winner = new ArrayList<>(winnerCounts.stream().toList());
        Collections.sort(winner);
        Collections.sort(loser);
        ans.add(winner);
        ans.add(loser);
        return ans;
    }
}