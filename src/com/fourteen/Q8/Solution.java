package com.fourteen.Q8;

public class Solution {

    public static void main(String[] args) {
        String s = "21474836460";

        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        StringBuffer str = new StringBuffer();
        //前导空格是否结束
        Boolean flag = false;
        //是否遇到符号位
        Boolean flag2 = false;
        //是正数还是负数
        Boolean flag3 = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && !flag ) {
                if(i + 1 == s.length() || (i + 1 < s.length() && s.charAt(i + 1) != ' ')){
                    flag = true;
                }
                continue;
            }
            if (!flag2 && s.charAt(i) == '-') {
                flag2 = true;
                flag3 = true;
                continue;
            } else if (!flag2 && s.charAt(i) == '+') {
                flag2 = true;
                continue;
            }

            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                str.append(s.charAt(i));
                flag = true;
                flag2 = true;
            } else {
                break;
            }

        }

        if (str.length() == 0) {
            return 0;
        } else {
            try {
                int res = flag3 ? -Integer.valueOf(str.toString()) : Integer.valueOf(str.toString());
                return res;
            } catch (Exception e) {
                return flag3 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
    }


}
