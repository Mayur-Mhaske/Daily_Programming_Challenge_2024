public class ReverseWords {
    public static String reverseWords(String s) {
        // Trim the string and split it by whitespace
        String[] words = s.trim().split("\\s+");
        
        StringBuilder reversed = new StringBuilder();
        
        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" "); // Add space between words
            }
        }
        
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        String output = reverseWords(input);
        System.out.println(output);  // Output: "blue is sky the"
    }
}