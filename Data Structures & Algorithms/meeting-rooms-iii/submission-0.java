class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Available rooms: lowest room number first
        PriorityQueue<Integer> available = new PriorityQueue<>();

        // Busy rooms: earliest end time first
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free all rooms available by the meeting's start time
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                // Use the lowest-numbered available room
                int room = available.poll();
                count[room]++;
                busy.offer(new long[]{end, room});
            } else {
                // Delay meeting until the earliest room becomes free
                long[] earliest = busy.poll();

                long freeTime = earliest[0];
                int room = (int) earliest[1];

                count[room]++;

                busy.offer(new long[]{freeTime + duration, room});
            }
        }

        // Lowest room number wins ties
        int answer = 0;

        for (int room = 1; room < n; room++) {
            if (count[room] > count[answer]) {
                answer = room;
            }
        }

        return answer;
    }
}