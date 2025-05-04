class Solution {

    public boolean isPathCrossing(String path) {
        List<List<Integer>> paths = new ArrayList<>();
        paths.add(List.of(0, 0));

        int x = 0, y = 0;
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;

            List<Integer> current = List.of(x, y);

            if (paths.contains(current)) {
                return true;
            }

            paths.add(current);
        }

        return false;
    }
}