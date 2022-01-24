package com.fourteen.Q219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/19 9:36
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2,3,1,2,3};
        int k = 2;
        System.out.println(new Solution().containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j - i <= k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

}
