class Solution {
  public int[] getSneakyNumbers(int[] nums) {
    int[] ans = new int[2];
    int i = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        ans[i++] = num;
      } else {
        set.add(num);
      }
    }
    return ans;
  }
}