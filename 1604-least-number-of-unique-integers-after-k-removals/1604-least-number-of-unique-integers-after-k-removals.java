class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int i : arr) {
      count.put(i, count.getOrDefault(i, 0) + 1);
    }

    List<Integer> ordered = new ArrayList<>(count.values());
    Collections.sort(ordered, Comparator.reverseOrder());
    while (k > 0) {
      int val = ordered.get(ordered.size() - 1);
      if (val <= k) {
        k -= val;
        ordered.remove(ordered.size() - 1);
      } else {
        break;
      }
    }
    return ordered.size();
  }
}