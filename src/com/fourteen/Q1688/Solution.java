package com.fourteen.Q1688;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/25 9:21
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfMatches(14));
    }

    public int numberOfMatches(int n) {
        int sum = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                sum += n;
            } else {
                sum += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return sum;
    }

}
