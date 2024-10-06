import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }

    public static void sortStack(Stack<Integer> stack) {
        // Base case: If the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the popped element back into the sorted stack
        insertInSortedOrder(stack, top);
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: If the stack is empty or the top element is less than or equal to the element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Pop the top element
        int top = stack.pop();

        // Recursively call to insert the element
        insertInSortedOrder(stack, element);

        // Push the top element back
        stack.push(top);
    }
}
