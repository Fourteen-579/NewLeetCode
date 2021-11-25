package com.fourteen.Q458;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<LocalDate> date = new ArrayList<>();
        date.add(LocalDate.now());
        date.add(LocalDate.now().plusDays(1));
        date.add(LocalDate.now().plusDays(2));
        date.add(LocalDate.now().plusDays(3));
        date.add(LocalDate.now().plusDays(4));
        date.add(LocalDate.now().plusDays(5));
        date.add(LocalDate.now().plusDays(6));

        List<Integer> nums = new ArrayList<>();
        nums.add(20);
        nums.add(40);
        nums.add(10);
        nums.add(0);
        nums.add(20);
        nums.add(10);
        nums.add(0);
        System.out.println(new Solution().getAverageBreedingTime(date,nums));
    }

    /**
     * 获取平均配种时间
     * @param date 配种时间
     * @param nums 配种数量
     * @return 结果
     */
    public LocalDate getAverageBreedingTime(List<LocalDate> date, List<Integer> nums) {
        LocalDate res = null;
        if (date != null && date.size() > 0 && nums != null && nums.size() > 0 && nums.size() == date.size()) {
            int days = 0, k = 0, all = 0;
            for (Integer num : nums) {
                days += num * k++;
                all += num;
            }
            res = date.get(0).plusDays(days / all);
        }
        return res;
    }

}
