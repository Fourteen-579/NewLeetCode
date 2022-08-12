package com.fourteen.Q1374;

import java.util.Collections;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/8/12 10:17
 */
public class Solution {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().generateTheString(n));
    }
    public String generateTheString(int n) {
        String str = null;

        String a = "a";
        String b = "b";

        if (n % 2 == 0) {
            str = String.join("", Collections.nCopies(n - 1, a));
            str += b;
        } else {
            str = String.join("", Collections.nCopies(n, a));
        }

        return str;
    }
}
