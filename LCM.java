import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two integers
        System.out.print("Enter first number (N): ");
        int N = scanner.nextInt();
        System.out.print("Enter second number (M): ");
        int M = scanner.nextInt();

        int lcm = findLCM(N, M);
        System.out.println("LCM of " + N + " and " + M + " is: " + lcm);
    }

    public static int findLCM(int N, int M) {
        return (N * M) / findGCD(N, M);
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
