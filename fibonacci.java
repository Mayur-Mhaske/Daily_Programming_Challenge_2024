public class fibonacci {
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        
        // Create an array to store Fibonacci numbers
        int[] fib = new int[n + 1];
        fib[0] = 0; // Base case
        fib[1] = 1; // Base case

        // Fill the array in a bottom-up manner
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println(fibonacci(n)); // Output: 5
    }
}
