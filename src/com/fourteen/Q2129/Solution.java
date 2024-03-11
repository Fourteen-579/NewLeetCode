package com.fourteen.Q2129;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/3/11 14:48
 */
public class Solution {
    public static void main(String[] args) {
        int a = 'a';
        int b = 'A';
        System.out.println(a + "\n" + b);
    }

    public String capitalizeTitle(String title) {
        StringBuilder result = new StringBuilder();

        String[] split = title.split(" ");
        for (String s : split) {
            String lowerCase = s.toLowerCase();
            if (s.length() < 3) {
                result.append(lowerCase);
            } else {
                int i = lowerCase.charAt(0) - 32;

                result.append((char) i).append(lowerCase.substring(1));
            }
            result.append(" ");
        }

        return result.substring(0, result.length() - 1);
    }
}