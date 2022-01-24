package com.fourteen.Q1332;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/24 11:31
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isHui("abab"));
    }

    public boolean isHui(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (isHui(s)) {
            return 1;
        } else {
            return 2;
        }
    }

}
