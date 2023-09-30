package medium;

import java.util.Arrays;

public class CoinChange322 {

    // Bottom-up approach - Dynamic Programming
    public int coinChange(int[] coins, int amount) {

        if(amount == 0)
            return 0;

        // array represents: dp[i] -> how many coins required to get amount of i?
        // i.e. dp[0] = 0 - we need 0 coins to get amount 0. And so on..
        // why size is [amount+1] -> we have dp[0] and no coins with value 0, so to store all amounts from 0 to 11
        // we need 12 cells
        int[] dp = new int[amount + 1];

        // fill dp array with values who are for sure unrealistic,
        // so we cannot use more coins than represented by amount itself
        Arrays.fill(dp, amount+1);

        // no coins needed to achieve amount 0:
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange322().coinChange(new int[]{1,2,5},11));
    }
}
