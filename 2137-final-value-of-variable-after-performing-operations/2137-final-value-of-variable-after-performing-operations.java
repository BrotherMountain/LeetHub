class Solution {
  public int finalValueAfterOperations(String[] operations) {
    Map<String, Integer> count = new HashMap<>();
    for (String operation : operations) {
      if (operation.equals("X++")) {
        operation = "++X";
      }
      if (operation.equals("X--")) {
        operation = "--X";
      }
      count.put(operation, count.getOrDefault(operation, 0) + 1);
    }

    return count.getOrDefault("++X",0) - count.getOrDefault("--X",0);
  }
}