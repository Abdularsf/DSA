import java.util.HashMap;

public class K_distinct_char_optimal {
    public int kDistinctChar(String s, int k) {
        int maxLength = 0;
        int n = s.length();
        int left = 0, right = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        while (right < n) {
            char ch = s.charAt(right);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
            if (mpp.size() > k) {
                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }
                left++;
            }
            if (mpp.size() <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        K_distinct_char_optimal sol = new K_distinct_char_optimal();
        int length = sol.kDistinctChar(s, k);
        System.out.println("Maximum length of substring with at most " + k + " distinct characters: " + length);
    }
}
