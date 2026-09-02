class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store queries with their original indices
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[queries.length];

        // Min-heap: [interval length, right endpoint]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int i = 0;

        for (int[] query : sortedQueries) {
            int q = query[0];

            // Add all intervals that start <= query
            while (i < intervals.length && intervals[i][0] <= q) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;

                pq.offer(new int[]{length, right});
                i++;
            }

            // Remove intervals that don't contain the query
            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            result[query[1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return result;
    }
}