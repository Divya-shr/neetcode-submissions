class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max-heap based on squared distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                distance(b),
                distance(a)
            )
        );

        for (int[] point : points) {

            maxHeap.offer(point);

            // Keep only k closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Build result
        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        int x = point[0];
        int y = point[1];

        return x * x + y * y;
    }
}