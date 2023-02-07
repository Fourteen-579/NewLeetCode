package com.fourteen.Q1790;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/10/11 10:37
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ac";
        System.out.println(new Solution().areAlmostEqual(s1, s2));
    }

    public boolean areAlmostEqual(String s1, String s2) {

        int diff1 = -1, diff2 = -1, diff = 0;
        int len = s1.length();

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i) && diff < 2) {
                diff++;
                if (diff1 == -1) {
                    diff1 = i;
                } else {
                    diff2 = i;
                    break;
                }
            }
        }

        if (diff == 0) {
            return true;
        } else if(diff == 2){
            char[] chars = s1.toCharArray();
            chars[diff1] = s1.charAt(diff2);
            chars[diff2] = s1.charAt(diff1);

            String s = String.copyValueOf(chars);

            return s.equals(s2);
        }else{
            return false;
        }
    }
}
