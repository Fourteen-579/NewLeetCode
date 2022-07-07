package com.fourteen.Q11;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/7/6 12:22
 */
public class Solution {
    public int maxArea(int[] height) {
        int result = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            result = Math.max(result,
                    (right - left) * Math.min(height[right], height[left]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
