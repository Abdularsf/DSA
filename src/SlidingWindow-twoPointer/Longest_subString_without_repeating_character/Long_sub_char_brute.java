public class Long_sub_char_brute {
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1)
                    break;
                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "cadbzabcd";
        Long_sub_char_brute sol = new Long_sub_char_brute();
        int length = sol.longestNonRepeatingSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}