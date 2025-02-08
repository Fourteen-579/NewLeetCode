package com.fourteen.Q42;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/5 10:07
 */
public class Solution {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }

    public int trap(int[] height) {
        int result = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int leftMaxVal = height[0];
        int rightMaxVal = height[height.length - 1];

        for (int i = 0; i < height.length; i++) {
            if (height[i] > leftMaxVal) {
                leftMaxVal = height[i];
            }
            leftMax[i] = leftMaxVal;
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > rightMaxVal) {
                rightMaxVal = height[i];
            }
            rightMax[i] = rightMaxVal;
        }

        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }

}
