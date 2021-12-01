package com.fourteen.Q1446;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/1 13:43
 */
public class Solution {

    public static void main(String[] args) {
        String s = "cc";
        System.out.println(new Solution().maxPower(s));
    }

    public int maxPower(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 0;


        int left = 0;
        int right = left + 1;
        Character c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                right++;
            } else {
                max = Math.max(right - left, max);
                left = i;
                right = left + 1;
                c = s.charAt(i);
            }
        }

        max = Math.max(right - left, max);

        return max;
    }
}
