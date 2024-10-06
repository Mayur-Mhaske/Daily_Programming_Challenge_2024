import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args) {
        int N = 18;
        List<Integer> primeFactors = primeFactorization(N);
        System.out.println(primeFactors);  // Output: [2, 3, 3]
    }

    public static List<Integer> primeFactorization(int N) {
        List<Integer> factors = new ArrayList<>();

        // Check for number of 2s that divide N
        while (N % 2 == 0) {
            factors.add(2);
            N /= 2;
        }

        // N must be odd at this point so we can skip one element (i.e., check only odd numbers)
        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                factors.add(i);
                N /= i;
            }
        }

        // This condition is to check if N is a prime number greater than 2
        if (N > 2) {
            factors.add(N);
        }

        return factors;
    }
}
