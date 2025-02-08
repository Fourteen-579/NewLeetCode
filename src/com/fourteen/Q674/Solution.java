package com.fourteen.Q674;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/7 9:33
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int result = new Solution().findLengthOfLCIS(nums);
        System.out.println(result);
    }

    public int findLengthOfLCIS(int[] nums) {
        int result = 0;

        int count = 1;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > current) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
            current = nums[i];
        }

        return Math.max(result, count);
    }

}
