package com.fourteen.Q458;

import java.time.LocalDate;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        List<Date> date = new ArrayList<>();
        date.add(new Date(System.currentTimeMillis()));
        date.add(new Date(System.currentTimeMillis()+86400000));
        date.add(new Date(System.currentTimeMillis()+86400000*2));
        date.add(new Date(System.currentTimeMillis()+86400000*3));
        date.add(new Date(System.currentTimeMillis()+86400000*4));
        date.add(new Date(System.currentTimeMillis()+86400000*5));
        date.add(new Date(System.currentTimeMillis()+86400001));

        LocalDate s = LocalDate.ofEpochDay(System.currentTimeMillis()/86400000);
        System.out.println(s);

        /*List<Integer> nums = new ArrayList<>();
        nums.add(20);
        nums.add(40);
        nums.add(10);
        nums.add(0);
        nums.add(20);
        nums.add(10);
        nums.add(0);

        Map<Date, Integer> map = new TreeMap<>();

        for (int i = 0; i < date.size(); i++) {
            if (!map.containsKey(date.get(i))) {
                map.put(date.get(i), nums.get(i));
            } else {
                map.put(date.get(i), map.get(date.get(i)) + nums.get(i));
            }
        }

        System.out.println(new Solution().getAverageBreedingTime(map));*/
    }

    /**
     * 获取平均配种时间
     *
     * @param map 时间和数量对应map
     * @return
     */
    public Date getAverageBreedingTime(Map<Date, Integer> map) {
        //防止传进来的map没有排序
        Map<Date, Integer> maps = new TreeMap<>(Comparator.naturalOrder());
        maps.putAll(map);

        Date res = null;
        int days = 0, k = 0, all = 0;
        Set<Map.Entry<Date, Integer>> entries = map.entrySet();
        //记录第一天
        Boolean flag = false;

        for (Map.Entry<Date, Integer> entry : entries) {
            days += entry.getValue() * k++;
            all += entry.getValue();
            if (!flag) {
                res = entry.getKey();
                flag = true;
            }
        }
        if (days > 0) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(res);
            calendar.add(calendar.DATE, days / all); //把日期往后增加一天,整数  往后推,负数往前移动
            res = calendar.getTime();
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
    public Date getAverageBreedingTime(List<Date> date, List<Integer> nums) {
        Date res = null;
        if (date != null && date.size() > 0 && nums != null && nums.size() > 0 && nums.size() == date.size()) {
            Map<Date, Integer> map = new HashMap<>();

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
