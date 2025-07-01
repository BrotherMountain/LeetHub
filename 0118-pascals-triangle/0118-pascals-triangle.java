class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        ans.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = ans.get(i - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < i; j++) {
                int value = prev.get(j - 1) + prev.get(j);
                current.add(value);
            }
            current.add(1);
            ans.add(current);
        }
        return ans;
    }

}