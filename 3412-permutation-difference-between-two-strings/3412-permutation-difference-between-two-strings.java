class Solution {
    public int findPermutationDifference(String s, String t) {
       Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }

        int ans = 0;

        for(int i=0; i<t.length(); i++){
            ans += Math.abs(i - map.get(t.charAt(i)));
        }

        return ans;
    }
}