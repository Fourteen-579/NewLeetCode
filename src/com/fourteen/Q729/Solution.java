package com.fourteen.Q729;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/7/5 12:37
 */
public class Solution {
}

class MyCalendar {

    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int length = list.size();
        if (length == 0) {
            list.add(new int[]{start, end});
            return true;
        }
        int i;
        for (i = 0; i < length; i++) {
            int[] ints = list.get(i);
            if (end <= ints[0]) {
                list.add(i,new int[]{start, end});
                return true;
            } else if (start >= ints[1]) {
                continue;
            } else {
                return false;
            }
        }
        if (i == length) {
            list.add(new int[]{start, end});
        }
        return true;
    }
}
