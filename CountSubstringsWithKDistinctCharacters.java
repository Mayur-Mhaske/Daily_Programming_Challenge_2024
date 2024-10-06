import java.util.HashMap;

public class CountSubstringsWithKDistinctCharacters {
    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        System.out.println(countSubstringsWithKDistinct(s, k));  // Output: 7
    }

    public static int countSubstringsWithKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private static int atMostKDistinct(String s, int k) {
        if (k == 0) return 0;

        HashMap<Character, Integer> charCount = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0) + 1);

            while (charCount.size() > k) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                if (charCount.get(s.charAt(left)) == 0) {
                    charCount.remove(s.charAt(left));
                }
                left++;
            }

            result += right - left + 1; // All substrings ending at 'right' and starting from 'left' to 'right'
        }

        return result;
    }
}
