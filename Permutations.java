import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // Sort the array to handle duplicates
        boolean[] visited = new boolean[chars.length];
        backtrack(result, new StringBuilder(), chars, visited);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, char[] chars, boolean[] visited) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;

            // Avoid duplicates
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true; // Mark as visited
            current.append(chars[i]); // Add to current permutation
            backtrack(result, current, chars, visited); // Recursive call
            visited[i] = false; // Backtrack
            current.deleteCharAt(current.length() - 1); // Remove last character
        }
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> output = permute(input);
        System.out.println(output); // Output: ["abc", "acb", "bac", "bca", "cab", "cba"]
    }

    
}
