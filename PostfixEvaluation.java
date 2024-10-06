import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        String expression = "2 1 + 3 *";
        int result = evaluatePostfix(expression);
        System.out.println("Result: " + result);  // Output: 9
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Split the expression into tokens (numbers and operators)
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            // If the token is a number, push it onto the stack
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // The token is an operator, pop two elements from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);  // Push the result back onto the stack
            }
        }

        // The final result will be the only element left in the stack
        return stack.pop();
    }

    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                // Perform integer division, truncating towards zero
                return (operand1 / operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
