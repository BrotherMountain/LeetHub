class LFUCache {
    // Node는 값(value)과 빈도수(freq)를 함께 저장
    private static class Node {
        int value;
        int freq;

        Node(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> cache; // key -> Node(value, freq)
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        updateFrequency(key);
        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (cache.containsKey(key)) {
            cache.get(key).value = value; // 값만 업데이트
            updateFrequency(key);
            return;
        }

        if (cache.size() >= capacity) {
            int keyToRemove = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(keyToRemove);
            cache.remove(keyToRemove);
        }

        cache.put(key, new Node(value, 1));
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        this.minFreq = 1;
    }

    private void updateFrequency(int key) {
        Node node = cache.get(key);
        int freq = node.freq;
        
        freqToKeys.get(freq).remove(key);
        if (freq == minFreq && freqToKeys.get(freq).isEmpty()) {
            minFreq++;
        }

        node.freq++;
        freqToKeys.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */