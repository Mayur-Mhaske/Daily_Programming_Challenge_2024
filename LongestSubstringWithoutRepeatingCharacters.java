import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));  // Output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and its index is greater than or equal to left
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1; // Move left pointer to the right of the last occurrence
            }

            charIndexMap.put(currentChar, right); // Update the character's latest index
            maxLength = Math.max(maxLength, right - left + 1); // Update max length
        }

        return maxLength;
    }
}
