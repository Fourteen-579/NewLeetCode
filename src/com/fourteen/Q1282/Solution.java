package com.fourteen.Q1282;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/8/12 9:12
 */
public class Solution {

    public static void main(String[] args) {
        int[] gs = {2,1,3,3,3,2};
        List<List<Integer>> lists = new Solution().groupThePeople(gs);
        lists.forEach(item -> {
            System.out.println(Arrays.toString(item.toArray()));
        });
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int finalI = i;
            map.compute(groupSizes[i], (integer, integers) -> {
                if (integers == null) {
                    integers = new ArrayList<>();
                }
                integers.add(finalI);
                return integers;
            });

            if (map.get(groupSizes[i]).size() == groupSizes[i]) {
                result.add(map.get(groupSizes[i]));
                map.remove(groupSizes[i]);
            }
        }

        return result;
    }
}
