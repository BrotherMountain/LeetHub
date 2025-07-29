class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }
    
    static void dfs(int num, int[][] isConnected, boolean[] visited){
        if(visited[num]) return;
        visited[num]=true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[num][i]==1){
                dfs(i, isConnected, visited);
            }
        }
    }
}