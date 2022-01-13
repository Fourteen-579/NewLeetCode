package com.fourteen.Q747;

import java.util.Arrays;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/13 9:46
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        System.out.println(new Solution().dominantIndex(nums));
    }

    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int max = nums[0];
        int index = 0;
        boolean flag = true;
        for (int i = 1; i < len; i++) {
            if (max < nums[i]) {
                if (nums[i] >= max * 2) {
                    flag = true;
                } else {
                    flag = false;
                }
                max = nums[i];
                index = i;
                continue;
            }
            if (max >= nums[i] * 2) {
                flag = flag && true;
            } else {
                flag = false;
            }
        }
        return flag ? index : -1;
    }

}
