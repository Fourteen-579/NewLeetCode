package com.fourteen.Q1984;

import java.util.Arrays;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/11 10:13
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {87063, 61094, 44530, 21297, 95857, 93551, 9918};
        int k = 6;
        System.out.println(new Solution().minimumDifference(nums, k));
    }

    public int minimumDifference(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        int length = nums.length;
        Arrays.sort(nums);
        if (length == 1) {
            return 0;
        }

        int left = 0, right = left + k - 1;
        while (right < length) {
            res = Math.min(res, nums[right++] - nums[left++]);
        }

        return res;
    }

}
