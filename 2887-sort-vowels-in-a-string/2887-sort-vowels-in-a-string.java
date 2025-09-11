class Solution {
  public String sortVowels(String s) {
    PriorityQueue<Character> pq = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder(s);

    for (char c : s.toCharArray()) {
      if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
        pq.add(c);
      }
    }

    int index = 0;
    while (!pq.isEmpty()) {
      if (sb.charAt(index) == 'a' || sb.charAt(index) == 'e' || sb.charAt(index) == 'i'
          || sb.charAt(index) == 'o' || sb.charAt(index) == 'u' || sb.charAt(index) == 'A' || sb.charAt(index) == 'E' || sb.charAt(index) == 'I'
          || sb.charAt(index) == 'O' || sb.charAt(index) == 'U') {
        sb.replace(index, index+1, String.valueOf(pq.remove()));
      }
      index++;
    }
    return sb.toString();
  }
}