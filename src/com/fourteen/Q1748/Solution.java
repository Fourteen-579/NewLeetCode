package com.fourteen.Q1748;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/7 10:39
 */
public class Solution {

    public int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    res -= num;
                }
                map.put(num, map.get(num) + 1);
            } else {
                res += num;
                map.put(num, 1);
            }
        }


        return res;
    }

}
