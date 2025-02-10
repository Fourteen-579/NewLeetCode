package com.fourteen.NC149;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/7 9:46
 */
public class Solution {

    public static void main(String[] args) {
        String S = "ababab";
        String T = "abababab";
        int result = new Solution().kmp(S, T);
        System.out.println(result);
    }

    public int kmp(String S, String T) {
        if (S.length() > T.length()) {
            return 0;
        } else if (S.length() == T.length()) {
            return S.equals(T) ? 1 : 0;
        }

        int result = 0;

        for (int i = 0; i < T.length() - S.length() + 1; i++) {
            String substring = T.substring(i, i + S.length());
            if (substring.equals(S)) {
                result++;
            }
        }

        return result;
    }

}
