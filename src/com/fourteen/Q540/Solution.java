package com.fourteen.Q540;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/18 10:00
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - left) % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((right - mid) % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[right];
    }

}
