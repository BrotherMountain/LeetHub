class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> ans = new ArrayList<>();
    int n = words.length;
    for (int i = 0; i < n; i++) {
      String word = words[i];
      char[] charArray = word.toCharArray();
      boolean isContain = false;
      for (char c : charArray) {
        if (c == x) {
          isContain = true;
          break;
        }
      }
      if (isContain) {
        ans.add(i);
      }
    }
    return ans;
  }
}