package com.fourteen.Q1154;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/21 9:31
 */
public class Solution {

    public static void main(String[] args) {
        String str = "2004-03-01";
        System.out.println(new Solution().dayOfYear(str));
    }

    public int dayOfYear(String date) {
        int day = 0;
        int[] monthDay = {0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");
        if (Integer.valueOf(split[0]) % 4 == 0) {
            monthDay[2] = 29;
        } else {
            monthDay[2] = 28;
        }
        int m = Integer.valueOf(split[1]) - 1;
        while (m >= 0) {
            day += monthDay[m--];
        }
        day += Integer.valueOf(split[2]);

        return day;
    }
}
