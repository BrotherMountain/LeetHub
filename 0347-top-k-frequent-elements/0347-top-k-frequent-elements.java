class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counts = new HashMap<>();
        for(int num: nums){
            counts.put(num, counts.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Integer>heap = new PriorityQueue<>((n1,n2)-> counts.get(n1)-counts.get(n2));
        for(int num: counts.keySet()){
            heap.add(num);
            if(heap.size()>k){
                heap.remove();
            }
        }

        int[] ans = new int[k];

        for(int i =0; i < k; i++){
            ans[i] = heap.remove();
        }

        return ans;
    }
}