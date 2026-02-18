
public class longest_repeating_char_better {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] hash = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        int right = 0;
        int left = 0;
        while (right < n) {
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;
                maxFreq = 0;
                for (int i = 0; i < 26; ++i) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        longest_repeating_char_better sol = new longest_repeating_char_better();
        int length = sol.characterReplacement(s, k);
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + length);
    }
}
