class Solution {
  public int findClosest(int x, int y, int z) {
    int person1ToPerson3 = Math.abs(z - x);
    int person2ToPerson3 = Math.abs(z - y);
    if (person1ToPerson3 < person2ToPerson3) {
      return 1;
    } else if (person1ToPerson3 > person2ToPerson3) {
      return 2;
    } else {
      return 0;
    }
  }
}