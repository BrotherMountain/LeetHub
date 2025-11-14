class Solution {
  public int uniqueMorseRepresentations(String[] words) {
    String[] moss = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
        ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."};
    Set<String> set = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (char c : word.toCharArray()) {
        String s = moss[c - 'a'];
        sb.append(s);
      }
      set.add(sb.toString());
    }
    return set.size();
  }
}