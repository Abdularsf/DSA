import java.util.Arrays;

public class Long_sub_char_optimal {
    public int longestNonRepeatingSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < n) {
            if (hash[s.charAt(right)] != -1) {
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }
            int length = right - left + 1;
            maxLength = Math.max(length, maxLength);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "cadbzabcd";
        Long_sub_char_optimal sol = new Long_sub_char_optimal();
        int length = sol.longestNonRepeatingSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}
