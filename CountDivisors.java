import java.util.Scanner;

public class CountDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer N: ");
        int N = scanner.nextInt();
        
        int divisorCount = countDivisors(N);
        System.out.println("Total number of divisors of " + N + " is: " + divisorCount);
    }

    public static int countDivisors(int N) {
        int count = 0;
        // Iterate from 1 to the square root of N
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) { // If i is a divisor
                count++; // Count i
                if (i != N / i) { // Count the complementary divisor
                    count++;
                }
            }
        }
        return count;
    }
}

