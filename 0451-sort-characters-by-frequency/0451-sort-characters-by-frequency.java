class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        LinkedList<Character> linkedList = new LinkedList<>(count.keySet());
        linkedList.sort((a, b) -> count.get(b) - count.get(a));

        StringBuilder sb = new StringBuilder();
        for (Character c : linkedList) {
            int freq = count.get(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}