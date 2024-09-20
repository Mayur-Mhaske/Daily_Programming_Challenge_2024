import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Sort the characters of the string to form the key
            char[] charArray = str.toCharArray();
            java.util.Arrays.sort(charArray);
            String key = new String(charArray);

            // Add the string to the corresponding list in the hashmap
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(str);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = groupAnagrams(input);
        System.out.println(output);  // Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
    }
    
}
