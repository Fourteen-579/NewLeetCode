package com.fourteen.Q322;

import java.util.Arrays;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/7 13:41
 */
public class Solution {

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(new Solution().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


}
