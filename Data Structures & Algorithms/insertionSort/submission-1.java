// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
        List<Pair> arr = new ArrayList<>(pairs);

        if (arr.isEmpty()) {
            return result;
        }

        // record initial state
        result.add(new ArrayList<>(arr));

        for (int i = 1; i < arr.size(); i++) {
            Pair current = arr.get(i);
            int j = i - 1;

            // shift elements greater than current.key to the right
            while (j >= 0 && arr.get(j).key > current.key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, current);

            // record state after this insertion
            result.add(new ArrayList<>(arr));
        }

        return result;
    }
}