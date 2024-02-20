package com.fourteen.Q1696;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/19 13:54
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;

        System.out.println(maxResult(nums, k));
    }

    public static int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int result = nums[0];
        for (int i = 0; i < nums.length - 1; ) {

            int numMax = nums[i + 1];
            int indexMax = 1;
            for (int j = 1; j <= k && i + j < nums.length; j++) {
                if (nums[i + j] > 0) {
                    numMax = nums[i + j];
                    indexMax = j;
                    break;
                }

                if (numMax < nums[i + j]) {
                    numMax = nums[i + j];
                    indexMax = j;
                }
            }

            result += numMax;
            i += indexMax;
        }

        return result;
    }

}
