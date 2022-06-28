package com.fourteen.Q324;

import java.util.Arrays;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/6/28 13:00
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        new Solution().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);

        int left = (nums.length + 1) / 2 - 1, right =nums.length-1;
        for (int i = 0; i < nums.length; i += 2, left--, right--) {
            nums[i] = clone[left];
            if (i + 1 < nums.length) {
                nums[i + 1] = clone[right];
            }
        }
    }
}
