package com.fourteen.Q539;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/18 10:29
 */
public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("01:01");
        list.add("02:01");
        list.add("03:00");

        System.out.println(new Solution().findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        timePoints.forEach(time -> {
            String[] split = time.split(":");
            list.add(Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]));
        });
        list.sort(Comparator.comparingInt(o -> o));
        int res = list.get(list.size() - 1) - list.get(0);
        if (res > 720) {
            res = 1440 - res;
        } else if (res < 0) {
            res += 1440;
        } else if (res == 0) {
            return 0;
        }
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i) - list.get(i - 1);
            if (temp > 720) {
                temp = 1440 - temp;
            } else if (temp < 0) {
                temp += 1440;
            } else if (temp == 0) {
                return 0;
            }
            res = Math.min(temp, res);
        }

        return res;
    }

}
