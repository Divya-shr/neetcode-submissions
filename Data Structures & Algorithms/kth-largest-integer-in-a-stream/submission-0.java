class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Add all initial values
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        minHeap.offer(val);

        // Keep only the k largest elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Smallest of the k largest = kth largest
        return minHeap.peek();
    }
}