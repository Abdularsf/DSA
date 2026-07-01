
public class longest_repeating_char_brute {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
                int changes = (j - i + 1) - maxFreq;
                if (changes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        longest_repeating_char_brute sol = new longest_repeating_char_brute();
        int length = sol.characterReplacement(s, k);
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + length);
    }
}
