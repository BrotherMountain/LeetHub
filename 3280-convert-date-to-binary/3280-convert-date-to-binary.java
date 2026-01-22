class Solution {
  public String convertDateToBinary(String date) {
    String[] split = date.split("-");
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < split.length; i++) {
      String binary = Integer.toBinaryString(Integer.parseInt(split[i]));
      sb.append(binary);
      if (i != split.length - 1) {
        sb.append("-");
      }
    }

    return sb.toString();
  }
}