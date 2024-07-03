package com.fourteen.Q3099;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/7/3 14:25
 */
public class Solution {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int num = x;
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num = num / 10;
        }

        sum += num;

        return x % sum == 0 ? sum : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfTheDigitsOfHarshadNumber(100));
    }

}
