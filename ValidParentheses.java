import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Mapping of closing brackets to their corresponding opening brackets
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Push opening brackets onto the stack
            } else {
                // Check for closing brackets
                if (stack.isEmpty()) {
                    return false; // No opening bracket to match
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false; // Mismatched pair
                }
            }
        }

        // If the stack is empty, all brackets were matched
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }

    public static void main(String[] args) {
        String input = "[{()}]";
        boolean output = isValid(input);
        System.out.println(output);  // Output: true
    }
    
}
