class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        int before = -1;
        List<Integer> list = count.values().stream().sorted().toList();
        for (int current : list) {
            if (before != current) {
                before = current;
            } else {
                return false;
            }
        }
        return true;
    }
}