class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        int up = 1;
        int down = 1;
        int answer = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) {
                up = down + 1;
                down = 1;

            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
                up = 1;

            } else {
                up = 1;
                down = 1;
            }

            answer = Math.max(answer, Math.max(up, down));
        }

        return answer;
    }
}