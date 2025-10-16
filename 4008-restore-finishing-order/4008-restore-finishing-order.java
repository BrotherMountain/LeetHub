class Solution {
  public int[] recoverOrder(int[] order, int[] friends) {
    Set<Integer> set = new HashSet<>();
    for (int friend : friends) {
      set.add(friend);
    }
    int index = 0;
    for (int i : order) {
      if (set.contains(i)) {
        friends[index++] = i;
      }
    }
    return friends;
  }
}