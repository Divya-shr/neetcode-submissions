class CountSquares {
    private Map<String, Integer> count;

    public CountSquares() {
        count = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        count.put(key, count.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int result = 0;

        for (String key : count.keySet()) {
            String[] parts = key.split(",");
            int x2 = Integer.parseInt(parts[0]);
            int y2 = Integer.parseInt(parts[1]);

            // Must be vertically aligned and different
            if (x2 != x || y2 == y) {
                continue;
            }

            int d = Math.abs(y2 - y);
            int verticalCount = count.get(key);

            // Square to the right
            int right1 = count.getOrDefault((x + d) + "," + y, 0);
            int right2 = count.getOrDefault((x + d) + "," + y2, 0);

            // Square to the left
            int left1 = count.getOrDefault((x - d) + "," + y, 0);
            int left2 = count.getOrDefault((x - d) + "," + y2, 0);

            result += verticalCount * right1 * right2;
            result += verticalCount * left1 * left2;
        }

        return result;
    }
}