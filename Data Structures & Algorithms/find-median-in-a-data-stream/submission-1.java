class MedianFinder {

    // Max-heap: smaller half
    private PriorityQueue<Integer> small;

    // Min-heap: larger half
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add to smaller half first
        small.offer(num);

        // Make sure every element in small <= every element in large
        if (!small.isEmpty() && !large.isEmpty()
                && small.peek() > large.peek()) {

            int smallTop = small.poll();
            int largeTop = large.poll();

            small.offer(largeTop);
            large.offer(smallTop);
        }

        // Balance the sizes
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (small.size() > large.size()) {
            return small.peek();
        }

        // Even number of elements
        return (small.peek() + large.peek()) / 2.0;
    }
}