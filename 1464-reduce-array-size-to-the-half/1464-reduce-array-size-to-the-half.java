class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int num : arr) {
            countsMap.put(num, countsMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(countsMap.values());
        
        counts.sort(Collections.reverseOrder());

        int numbersRemoved = 0;
        int setSize = 0;
        int targetSize = arr.length / 2;
        
        for (int count : counts) {
            numbersRemoved += count;
            setSize++;
            if (numbersRemoved >= targetSize) {
                break;
            }
        }
        
        return setSize;
    }
}