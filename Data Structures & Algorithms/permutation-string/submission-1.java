public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int[] window = new int[26];
        for (int i = 0; i < n1; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count, window)) return true;

        for (int right = n1; right < n2; right++) {
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(right - n1) - 'a']--;

            if (Arrays.equals(count, window)) return true;
        }

        return false;
    }
}