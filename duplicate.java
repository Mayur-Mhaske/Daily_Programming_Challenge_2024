public class duplicate {
    public static int findDuplicate(int[] arr) {
        // Step 1: Initialize two pointers
        int slow = arr[0];
        int fast = arr[0];

        // Step 2: Move the fast pointer twice as fast as the slow pointer
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Step 3: Find the entry point of the cycle (duplicate number)
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        // Return the duplicate number
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2}; // Example array
        System.out.println("Duplicate number: " + findDuplicate(arr)); // Output: 3
    }
}

    

