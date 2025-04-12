class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> winnerSet = new HashSet<>();
        HashMap<Integer, Integer> loserCounts = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] match : matches) {
            winnerSet.add(match[0]);
            loserCounts.put(match[1], loserCounts.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> loser = new ArrayList<>();
        for (int[] match : matches) {
            if (loserCounts.containsKey(match[1])) {
                if (loserCounts.get(match[1]) == 1) {
                    loser.add(match[1]);
                    winnerSet.remove(match[1]);
                } else if (loserCounts.get(match[1]) >= 2) {
                    winnerSet.remove(match[1]);
                }
            }
        }
        List<Integer> winner = new ArrayList<>(winnerSet);
        Collections.sort(winner);
        Collections.sort(loser);
        ans.add(winner);
        ans.add(loser);
        return ans;
    }
}