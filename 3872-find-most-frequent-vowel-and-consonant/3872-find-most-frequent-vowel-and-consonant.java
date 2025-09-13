class Solution {
  public int maxFreqSum(String s) {
    Map<Character, Integer> vowelMap = new HashMap<>();
    Map<Character, Integer> consonantMap = new HashMap<>();

    for (char c : s.toCharArray()) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
      } else {
        consonantMap.put(c, consonantMap.getOrDefault(c, 0) + 1);
      }
    }

    int vowelCount = 0;
    int consonantCount = 0;

    for (Character c : vowelMap.keySet()) {
      vowelCount = Math.max(vowelCount, vowelMap.get(c));
    }

    for (Character c : consonantMap.keySet()) {
      consonantCount = Math.max(consonantCount, consonantMap.get(c));
    }
    return vowelCount + consonantCount;
  }
}