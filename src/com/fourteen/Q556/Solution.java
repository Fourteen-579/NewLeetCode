package com.fourteen.Q556;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/7/4 14:27
 */
public class Solution {
    public int nextGreaterElement(int n) {
        int result = -1;

        if (n <= 11) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        int t = n;
        while (t > 0) {
            list.add(t % 10);
            t /= 10;
        }

        list.sort(Comparator.comparingInt(o -> o));

        //5123684
        //5123846


        return result;
    }
}
