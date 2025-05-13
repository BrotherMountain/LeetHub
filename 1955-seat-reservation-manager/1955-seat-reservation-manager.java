class SeatManager {
    PriorityQueue<Integer> heap;
    public SeatManager(int n) {
        heap = new PriorityQueue<>();
        for (int i = 1; i < n+1; i++) {
            heap.add(i);
        }
    }

    public int reserve() {
        return heap.remove();
    }

    public void unreserve(int seatNumber) {
        heap.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */