class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> isVisited = new HashSet<>();
        String ans = s;
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        isVisited.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.compareTo(ans) < 0) ans = cur;

            StringBuilder sb = new StringBuilder(cur);
            for (int i = 1; i < sb.length(); i += 2)
                sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));
            String added = sb.toString();
            if (isVisited.add(added)) queue.offer(added);

            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (isVisited.add(rotated)) queue.offer(rotated);
        }
        return ans;
    }
}