class Solution {
   public long maximumImportance(int n, int[][] roads) {
    long ans = 0;
    long cnt =1;
    long[] indegree = new long[n];

    for(int[] e:roads){
        indegree[e[0]]++;
        indegree[e[1]]++;
    }

    Arrays.sort(indegree);

    for(long i:indegree){
        ans+=i*cnt;
        cnt++;
    }
    return ans;
  }
}