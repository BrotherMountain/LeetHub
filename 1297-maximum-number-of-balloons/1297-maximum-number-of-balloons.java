class Solution {
    public int maxNumberOfBalloons(String text) {
        int ans = 0;
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        Integer a = counts.getOrDefault('a',0);
        Integer b = counts.getOrDefault('b',0);
        Integer l = counts.getOrDefault('l',0) / 2;
        Integer o = counts.getOrDefault('o',0) / 2;
        Integer n = counts.getOrDefault('n',0);
        while (a >= 1 && b >= 1 && l >= 1 && o >= 1 && n >= 1) {
            ans++;
            a--;
            b--;
            l--;
            o--;
            n--;
        }
        return ans;
    }
}