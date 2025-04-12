class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        Set<Integer> frequencies = new HashSet<>(counts.values());
        return frequencies.size() == 1;
    }
}