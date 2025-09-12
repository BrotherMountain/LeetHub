class Solution {
  public boolean asteroidsDestroyed(int mass, int[] asteroids) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int asteroid : asteroids) {
      pq.add(asteroid);
    }
    long ans = mass;
    while (!pq.isEmpty()) {
      int remove = pq.remove();
      if (ans >= remove) {
        ans += remove;
      } else {
        return false;
      }
    }
    return true;
  }
}