package com.fourteen.Q846;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/30 9:23
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,2,3,4,7,8};
        System.out.println(new Solution().isNStraightHand(nums, 3));
    }

    public boolean isNStraightHand(int[] nums, int k) {
        AtomicBoolean flag = new AtomicBoolean(true);
        if (nums.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        map.forEach((key, integer2) -> {
            boolean can = true;
            while (map.get(key) > 0) {
                for (int i = 0; i < k; i++) {
                    if (!map.containsKey(key + i) || (map.get(key + i) == 0)) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    for (int i = 0; i < k; i++) {
                        map.put(key + i, map.get(key + i) - 1);
                    }
                }else{
                    break;
                }
            }
        });

        map.forEach((integer, integer2) -> {
            if (integer2 != 0) {
                flag.set(false);
            }
        });

        return flag.get();
    }
}
