class Spreadsheet {

  final String AtoZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  Map<String, Integer> sheet;

  public Spreadsheet(int rows) {
    sheet = new HashMap<>();
    for (int col = 65; col <= 90; col++) {
      for (int row = 1; row <= rows; row++) {
        String colName = Character.toString(col);
        String cellName = colName + row;
        sheet.put(cellName, 0);
      }
    }
  }

  public void setCell(String cell, int value) {
    sheet.put(cell, value);
  }

  public void resetCell(String cell) {
    sheet.put(cell, 0);
  }

  public int getValue(String formula) {
    int plusIndex = formula.indexOf('+');
    String x = formula.substring(1, plusIndex);
    String y = formula.substring(plusIndex + 1);
    boolean xIsCell = AtoZ.indexOf(x.charAt(0)) != -1;
    boolean yIsCell = AtoZ.indexOf(y.charAt(0)) != -1;

    if (xIsCell && yIsCell) {
      return sheet.get(x) + sheet.get(y);
    } else if(!xIsCell && !yIsCell) {
      return Integer.parseInt(x) + Integer.parseInt(y);
    } else if (xIsCell) {
      return sheet.get(x) + Integer.parseInt(y);
    } else {
      return Integer.parseInt(x) + sheet.get(y);
    }
  }
}