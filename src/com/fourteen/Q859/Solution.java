package com.fourteen.Q859;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String s = "ac";
        String goal = "ca";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        if(s.length()==goal.length()){
            if (s.equals(goal)) {
                int[] nums = new int[26];
                Arrays.fill(nums, 0);
                for (int i = 0; i < s.length(); i++) {
                    if (nums[(int) s.charAt(i) - 'a'] == 1) {
                        return true;
                    } else {
                        nums[(int) s.charAt(i) - 'a']++;
                    }
                }
            } else {
                int flag = 0;
                char[][] chars = new char[2][2];
                int j = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != goal.charAt(i)) {
                        flag++;
                        if (j < 2) {
                            chars[j][0] = s.charAt(i);
                            chars[j++][1] = goal.charAt(i);
                        }
                    }
                    if (flag > 2) {
                        return false;
                    }
                }
                if (flag == 2 && chars[0][0] == chars[1][1] && chars[0][1] == chars[1][0]) {
                    return true;
                }
            }
        }
        return false;
    }
}