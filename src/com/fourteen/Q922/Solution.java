package com.fourteen.Q922;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(new int[]{2,3})));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (i % 2 == 0 && nums[i] % 2 != 0) {
                while (j < nums.length && !(j % 2 != 0 && nums[j] % 2 == 0)) {
                    j++;
                }
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            } else if (i % 2 != 0 && nums[i] % 2 == 0) {
                while (j < nums.length && !(j % 2 == 0 && nums[j] % 2 != 0)) {
                    j++;
                }
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            i++;
            j = i + 1;
        }

        return nums;
    }
}
