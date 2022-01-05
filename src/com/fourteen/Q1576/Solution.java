package com.fourteen.Q1576;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/5 10:30
 */
public class Solution {
    public static void main(String[] args) {
        String str = "??yw?ipkj?";
        System.out.println(new Solution().modifyString(str));
    }

    public String modifyString(String s) {
        if (s.length() == 1 && s.charAt(0) == '?') {
            return "a";
        } else if (s.length() == 1) {
            return s;
        }
        StringBuffer str = new StringBuffer(s);
        char a = 'a';
        char b = 'b';
        for (int i = 0; i < str.length(); i++) {
            char res = a;
            if (str.charAt(i) == '?') {
                if (i == 0) {
                    char c = str.charAt(i + 1);
                    if (c == a) {
                        res = b;
                    }
                } else if (i == str.length() - 1) {
                    char c = str.charAt(i - 1);
                    if (c == a) {
                        res = b;
                    }
                } else {
                    char c = str.charAt(i - 1);
                    char c2 = str.charAt(i + 1);
                    boolean flag = (c == a && c2 == b) || (c == b && c2 == a);
                    if (flag) {
                        res = 'c';
                    } else if (c == a || c2 == a) {
                        res = b;
                    }
                }
                str.setCharAt(i, res);
            }

        }


        return str.toString();
    }

}
