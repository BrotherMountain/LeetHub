class Solution {
  public int compareVersion(String version1, String version2) {
    String[] v1Revisions = version1.split("\\.");
    String[] v2Revisions = version2.split("\\.");
    int maxLength = Math.max(v1Revisions.length, v2Revisions.length);

    for (int i = 0; i < maxLength; i++) {
      int rev1 = (i < v1Revisions.length) ? Integer.parseInt(v1Revisions[i]) : 0;
      int rev2 = (i < v2Revisions.length) ? Integer.parseInt(v2Revisions[i]) : 0;
      if (rev1 > rev2) {
        return 1;
      }
      if (rev1 < rev2) {
        return -1;
      }
    }
    return 0;
  }
}