package com.fourteen.Q1005;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/3 9:34
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, -3, -1, 5, -4};
        int k = 2;
        System.out.println(new Solution().largestSumAfterKNegations(nums, k));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
            if (k > 0) {
                k--;
                nums[i] = -nums[i];
            } else {
                break;
            }
        }

        int min = 0;
        if (k > 0 && k % 2 != 0) {
            min = Arrays.stream(nums).min().getAsInt();
        }

        return Arrays.stream(nums).sum() - 2 * min;
    }

}
