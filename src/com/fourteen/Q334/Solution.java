package com.fourteen.Q334;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/12 9:44
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4};
        System.out.println(new Solution().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < a) {
                a = nums[i];
            } else if (nums[i] > a && nums[i] < b) {
                b = nums[i];
            } else if (nums[i] > b) {
                return true;
            }
        }

        return false;
    }
}
