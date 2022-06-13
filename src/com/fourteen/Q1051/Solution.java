package com.fourteen.Q1051;

import java.util.Arrays;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/6/13 16:08
 */
class Solution {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        System.out.println(new Solution().heightChecker(test));
    }

    public int heightChecker(int[] heights) {
        if (heights.length == 1) {
            return 0;
        }
        int result = 0;
        int[] clone = heights.clone();
        Arrays.sort(heights);

        for (int i = 0; i < clone.length; i++) {
            if (clone[i] != heights[i]) {
                result++;
            }
        }

        return result;
    }
}
