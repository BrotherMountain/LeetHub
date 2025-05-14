class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char curr = maxHeap.poll();
            int count = freq.get(curr);

            int use = Math.min(count, repeatLimit);
            for (int i = 0; i < use; i++) sb.append(curr);
            count -= use;

            if (count > 0) {
                if (maxHeap.isEmpty()) break;

                char next = maxHeap.poll();
                sb.append(next);

                freq.put(next, freq.get(next) - 1);
                if (freq.get(next) > 0) maxHeap.offer(next);

                freq.put(curr, count);
                maxHeap.offer(curr);
            } else {
                freq.remove(curr);
            }
        }

        return sb.toString();
    }
}