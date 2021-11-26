package com.fourteen.Q458;

import java.time.LocalDate;

import java.util.*;
import java.util.function.BiConsumer;

public class Solution {

    public static void main(String[] args) {
        List<LocalDate> date = new ArrayList<>();
        date.add(LocalDate.now());
        date.add(LocalDate.now().plusDays(1));
        date.add(LocalDate.now().plusDays(3));
        date.add(LocalDate.now().plusDays(6));
        date.add(LocalDate.now().plusDays(2));
        date.add(LocalDate.now().plusDays(5));
        date.add(LocalDate.now().plusDays(4));

        List<Integer> nums = new ArrayList<>();
        nums.add(20);
        nums.add(40);
        nums.add(10);
        nums.add(0);
        nums.add(20);
        nums.add(10);
        nums.add(0);

        Map<LocalDate, Integer> map = new TreeMap<>((o1, o2) -> o1.isAfter(o2) ? 1 : -1);

/*        for (int i = 0; i < date.size(); i++) {
            if (!map.containsKey(date.get(i))) {
                map.put(date.get(i), nums.get(i));
            } else {
                map.put(date.get(i), map.get(date.get(i)) + nums.get(i));
            }
        }*/

        System.out.println(new Solution().getAverageBreedingTime(map));
    }

    /**
     * 获取平均配种时间
     *
     * @param map 时间和数量对应map
     * @return
     */
    public LocalDate getAverageBreedingTime(Map<LocalDate, Integer> map) {
        //防止传进来的map没有排序
        Map<LocalDate, Integer> maps = new TreeMap<>((o1, o2) -> o1.isAfter(o2) ? 1 : -1);
        maps.putAll(map);

        LocalDate res = null;
        int days = 0, k = 0, all = 0;
        Set<Map.Entry<LocalDate, Integer>> entries = map.entrySet();
        //记录第一天
        Boolean flag = false;

        for (Map.Entry<LocalDate, Integer> entry : entries) {
            days += entry.getValue() * k++;
            all += entry.getValue();
            if (!flag) {
                res = entry.getKey();
                flag = true;
            }
        }
        if (days > 0) {
            res = res.plusDays(days / all);
        }
        return res;
    }

    /**
     * 获取平均配种时间
     *
     * @param date 配种时间
     * @param nums 配种数量（与时间对应）
     * @return 结果
     */
    public LocalDate getAverageBreedingTime(List<LocalDate> date, List<Integer> nums) {
        LocalDate res = null;
        if (date != null && date.size() > 0 && nums != null && nums.size() > 0 && nums.size() == date.size()) {
            Map<LocalDate, Integer> map = new HashMap<>();

            for (int i = 0; i < date.size(); i++) {
                if (!map.containsKey(date.get(i))) {
                    map.put(date.get(i), nums.get(i));
                } else {
                    map.put(date.get(i), map.get(date.get(i)) + nums.get(i));
                }
            }
            res = getAverageBreedingTime(map);
        }
        return res;
    }

}
