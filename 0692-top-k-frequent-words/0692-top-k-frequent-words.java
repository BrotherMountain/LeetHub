class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        PriorityQueue<String> heap = new PriorityQueue<>((str1, str2) ->
        {
            if (Objects.equals(count.get(str2), count.get(str1))) {
                return str2.compareTo(str1);
            }
            return count.get(str1) - count.get(str2);
        }
        );
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String string : count.keySet()) {
            heap.offer(string);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(heap.remove());
        }
        Collections.reverse(ans);
        return ans;
    }
}