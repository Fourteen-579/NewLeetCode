package com.fourteen.Q1518;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/17 9:24
 */
public class Solution {
    public static void main(String[] args) {
        int b = 2, e = 3;
        System.out.println(new Solution().numWaterBottles(b, e));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while (numBottles / numExchange > 0) {
            result += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }

        return result;
    }

}
