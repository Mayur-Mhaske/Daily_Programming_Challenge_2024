import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum coins for each amount
        int[] dp = new int[amount + 1];
        
        // Initialize dp array with a large value (greater than any possible number of coins)
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // Base case: 0 coins are needed to make the amount 0

        // Iterate through all amounts from 1 to the given amount
        for (int i = 1; i <= amount; i++) {
            // Check each coin
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still the initialized value, it means we cannot make that amount
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount)); // Output: 3
    }
}
