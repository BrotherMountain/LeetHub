class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set <Character> set = new HashSet<>();
        int ans =0;

        for(char ch:allowed.toCharArray()){
            set.add(ch);
        }

        for(int i=0;i<words.length;i++){
            int count=0;
            for(int j=0;j<words[i].length();j++){
                if(set.contains(words[i].charAt(j))){
                    count++;
                }
            }
            if(count == words[i].length()){
                ans++;
            }
        }

        return ans;
    }
}