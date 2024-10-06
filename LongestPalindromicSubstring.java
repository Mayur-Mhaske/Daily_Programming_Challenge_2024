public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes
            String oddPal = expandAroundCenter(s, i, i);
            if (oddPal.length() > longest.length()) {
                longest = oddPal;
            }
            // Check for even-length palindromes
            String evenPal = expandAroundCenter(s, i, i + 1);
            if (evenPal.length() > longest.length()) {
                longest = evenPal;
            }
        }
        return longest;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    
}
