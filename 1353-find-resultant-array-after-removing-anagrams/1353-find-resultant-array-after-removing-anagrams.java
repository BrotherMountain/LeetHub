class Solution {
  /**
   * 문제 접근: 애너그램이 존재하면 애너그램 삭제하기
   * 애너그램 = 정렬할 경우, 두 문자열이 일치해야함
   */
  public List<String> removeAnagrams(String[] words) {
    List<String> ans = new ArrayList<>();
    ans.add(words[0]);
    for (int i = 1; i < words.length; i++) {
      String s1 = words[i];
      String s2 = ans.get(ans.size() - 1);
      if (!isAnagram(s1, s2)) {
        ans.add(s1);
      }
    }
    return ans;
  }

  private boolean isAnagram(String s1, String s2) {
    //길이가 다르면 애너그램이 아님
    if (s1.length() != s2.length()) {
      return false;
    }

    char[] charArray1 = s1.toCharArray();
    char[] charArray2 = s2.toCharArray();
    Arrays.sort(charArray1);
    Arrays.sort(charArray2);
    //두 문자가 같지 않으면 애너그램이 아님
    return Arrays.equals(charArray1, charArray2);
  }

}