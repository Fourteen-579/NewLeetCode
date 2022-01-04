package com.fourteen.Q1185;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/4 9:21
 */
public class Solution {
    public static void main(String[] args) {
        int year = 1993;
        int month = 8;
        int day = 15;
        System.out.println(new Solution().dayOfTheWeek(day, month, year));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        LocalDate localDate = LocalDate.of(year, month, day);
        int value = localDate.getDayOfWeek().getValue();
        return week[value-1];
    }

}
