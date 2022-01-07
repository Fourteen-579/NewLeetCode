package com.fourteen.Q1614;

import java.util.Stack;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/7 9:34
 */
public class Solution {

    public int maxDepth(String s) {
        int res = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                temp ++;
            } else if (c == ')') {
                res = Math.max(res,temp);
                temp--;
            }
        }

        return res;
    }

}
