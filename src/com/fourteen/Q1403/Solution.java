package com.fourteen.Q1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/8/4 9:14
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 3, 10, 9, 8};
        System.out.println(new Solution().minSubsequence(nums));
    }

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int sum = Arrays.stream(nums).sum();

        int[] clone = nums.clone();
        Arrays.sort(clone);

        int sum2 = clone[clone.length - 1];
        list.add(clone[clone.length - 1]);

        for (int i = clone.length - 2; i >= 0; i--) {
            if (sum > sum2) {
                break;
            }
            sum -= clone[i];
            sum2 += clone[i];
            list.add(clone[i]);
        }


        return list;
    }
}
