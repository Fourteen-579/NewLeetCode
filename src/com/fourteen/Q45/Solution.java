package com.fourteen.Q45;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/21 9:29
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int result = 0;

        int start = 0;
        int end = start + nums[0];

        while (end < nums.length - 1) {
            int max = 0;
            for (int i = start + 1; i <= end; i++) {
                max = Math.max(max, nums[i] + i);
            }
            result++;
            start = start + 1;
            end = max;
        }

        return ++result;
    }

}
