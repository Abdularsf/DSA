import java.util.HashMap;

public class K_distinct_char_brute {
    public int kDistinctChar(String s, int k) {
        int maxLength = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> mpp = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
                if (mpp.size() <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        K_distinct_char_brute sol = new K_distinct_char_brute();
        int length = sol.kDistinctChar(s, k);
        System.out.println("Maximum length of substring with at most " + k + " distinct characters: " + length);
    }
}
