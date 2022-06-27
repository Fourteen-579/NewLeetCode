package com.fourteen.Q522;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/6/27 14:58
 */
public class Solution {
    public static void main(String[] args) {
        String son = "abc";
        String father = "aeece";
        System.out.println(new Solution().isSon(son, father));
    }

    public Boolean isSon(String son, String father) {
        boolean result = true;

        int i = 0, j = 0;
        for (i = 0; i < son.length(); i++, j++) {
            while (j < father.length() && son.charAt(i) != father.charAt(j)) {
                j++;
            }
            if (j == father.length()) {
                return false;
            }
        }

        return result;
    }

    public int findLUSlength(String[] strs) {
        int result = -1;

        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSon(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                result = Math.max(result,strs[i].length());
            }
        }

        return result;
    }
}
