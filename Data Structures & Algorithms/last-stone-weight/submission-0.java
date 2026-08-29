class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash two heaviest stones
        while (maxHeap.size() > 1) {

            int x = maxHeap.poll();
            int y = maxHeap.poll();

            // If they are different, add the remaining weight
            if (x != y) {
                maxHeap.offer(x - y);
            }
        }

        // Return last stone, or 0 if none remain
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}