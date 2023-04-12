package com.fourteen.Q2395;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/3/27 13:29
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,2,3,1};
        System.out.println(new Solution().findSubarrays(nums));
    }

    public boolean findSubarrays(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (sum == nums[j] + nums[j + 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
