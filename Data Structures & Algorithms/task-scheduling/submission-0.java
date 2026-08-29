class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Max heap: highest frequency first
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : count) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        // Queue: [remaining frequency, available time]
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            time++;

            // If a task is available, execute it
            if (!maxHeap.isEmpty()) {

                int remaining = maxHeap.poll();

                remaining--;

                // Put task into cooldown if it still has work
                if (remaining > 0) {
                    cooldown.offer(new int[] {
                        remaining,
                        time + n
                    });
                }
            }

            // Move cooled-down tasks back to heap
            if (!cooldown.isEmpty()
                    && cooldown.peek()[1] == time) {

                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}