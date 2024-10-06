import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }

    public static void reverseStack(Stack<Integer> stack) {
        // Base case: If the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively reverse the remaining stack
        reverseStack(stack);

        // Insert the popped element at the bottom of the reversed stack
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        // Base case: If the stack is empty, push the element
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively call to insert the element at the bottom
        insertAtBottom(stack, element);

        // Push the top element back onto the stack
        stack.push(top);
    }
}
