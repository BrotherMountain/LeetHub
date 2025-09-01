class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            double pass = c[0];
            double total = c[1];
            double gain = (pass + 1) / (total + 1) - pass / total;
            pq.offer(new double[]{gain, pass, total});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] currentClass = pq.poll();

            double pass = currentClass[1] + 1;
            double total = currentClass[2] + 1;

            double gain = (pass + 1) / (total + 1) - pass / total;
            pq.offer(new double[]{gain, pass, total});
        }

        double totalRatio = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            totalRatio += c[1] / c[2];
        }

        return totalRatio / classes.length;
    }
}