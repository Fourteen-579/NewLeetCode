package com.fourteen.Q686;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/22 15:07
 */
public class Solution {
    public static void main(String[] args) {
        String a = "abaababa";
        String b = "abaabaa";
        System.out.println(new Solution().repeatedStringMatch(a, b));
    }


    public int repeatedStringMatch(String a, String b) {
        int res = 1;
        StringBuffer str = new StringBuffer(a);
        while (str.length() < (2 * a.length() + b.length())) {
            if (str.indexOf(b) >= 0) {
                break;
            }
            str.append(a);
            res++;
        }
        if (str.indexOf(b) < 0) {
            res = -1;
        }

        return res;
    }
}
