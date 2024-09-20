public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the prefix as the first string
        String prefix = strs[0];

        // Compare the prefix with each string
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix
                prefix = prefix.substring(0, prefix.length() - 1);
                // If there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        String output = longestCommonPrefix(input);
        System.out.println(output);  // Output: "fl"
    }
}
