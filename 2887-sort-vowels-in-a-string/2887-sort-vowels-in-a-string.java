class Solution {
  private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
  }

  public String sortVowels(String s) {
    PriorityQueue<Character> vowels = new PriorityQueue<>();
    for (char c : s.toCharArray()) {
      if (isVowel(c)) {
        vowels.add(c);
      }
    }
    if (vowels.isEmpty()) {
      return s;
    }
    char[] ans = s.toCharArray();

    for (int i = 0; i < ans.length; i++) {
      if (isVowel(ans[i])) {
        ans[i] = vowels.remove();
      }
    }
    
    return new String(ans);
  }
}