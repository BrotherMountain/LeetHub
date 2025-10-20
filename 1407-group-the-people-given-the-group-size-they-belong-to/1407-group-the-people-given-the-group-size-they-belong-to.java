class Solution {
   public List<List<Integer>> groupThePeople(int[] groupSizes) {
    Map<Integer, List<Integer>> indexMap = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < groupSizes.length; i++) {
      int size = groupSizes[i];
      indexMap.putIfAbsent(size, new ArrayList<>());
      indexMap.get(size).add(i);

      if (indexMap.get(size).size() == size) {
        ans.add(new ArrayList<>(indexMap.get(size)));
        indexMap.get(size).clear();
      }
    }
    return ans;
  }
}