class SmallestInfiniteSet {
    PriorityQueue<Integer> heap;
    int size = 100;
    int maxValue = 100;
    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        for (int i = 1; i <= size; i++) {
            heap.add(i);
        }
    }

    public int popSmallest() {
        if (heap.isEmpty()) {
            size *= 10;
            scaleUp();
        }
        return heap.remove();
    }

    public void addBack(int num) {
        if (num >= size) {
            size = num * 10;
            scaleUp();
        }
        if (!heap.contains(num)) {
            heap.add(num);
            maxValue = Math.max(maxValue, num);
        }
    }

    public void scaleUp() {
        for (int i = maxValue+1; i <= size; i++) {
            heap.add(i);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */