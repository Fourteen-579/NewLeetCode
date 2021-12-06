package com.fourteen.Q383;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/6 9:44
 */
public class Solution {

    public static void main(String[] args) {
        String r = "aa";
        String m = "aab";
        System.out.println(new Solution().canConstruct(r,m));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        boolean flag = false;
        if (ransomNote.length() <= magazine.length()) {
            flag = true;
            StringBuffer m = new StringBuffer(magazine);
            for (int i = 0; i < ransomNote.length(); i++) {
                Character r = ransomNote.charAt(i);
                int index = m.indexOf(String.valueOf(r));
                if (index >= 0) {
                    m.deleteCharAt(index);
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

}
