package com.fourteen.Q2404;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/13 9:13
 */
public class Solution {
    public int mostFrequentEven(int[] nums) {
        int result = -1;

        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                Integer oldCount = map.getOrDefault(nums[i], 0);
                if (oldCount + 1 > maxNum || (oldCount + 1 == maxNum && result > nums[i])) {
                    maxNum = oldCount + 1;
                    result = nums[i];
                }
                map.put(nums[i], oldCount + 1);
            }
        }

        return result;
    }
}
