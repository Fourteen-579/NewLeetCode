package com.fourteen.Q3115;

import java.util.HashMap;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/7/2 14:37
 */
public class Solution {

    HashMap<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        int[] num = {1,7};

        System.out.println(new Solution().maximumPrimeDifference(num));
    }

    public int maximumPrimeDifference(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        boolean leftFlag = false, rightFlag = false;
        int leftIndex = 0, rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            if (!leftFlag) {
                if (isPrimeNumber(nums[leftIndex])) {
                    leftFlag = true;
                } else {
                    leftIndex++;
                }
            }

            if (!rightFlag) {
                if (isPrimeNumber(nums[rightIndex])) {
                    rightFlag = true;
                } else {
                    rightIndex--;
                }
            }

            if (leftFlag && rightFlag) {
                break;
            }
        }

        return rightIndex - leftIndex;
    }

    private boolean isPrimeNumber(Integer num) {
        if (map.containsKey(num)) {
            return map.get(num);
        }

        boolean result = true;
        if (num <= 1) {
            result = false;
        } else if (num == 2 || num == 3) {
            result = true;
        } else if (num % 2 == 0 || num % 3 == 0) {
            result = false;
        } else {
            int i = 5;
            while (i * i <= num) {
                if (num % i == 0 || num % (i + 2) == 0) {
                    result = false;
                    break;
                }
                i += 6;
            }
        }

        map.put(num, result);
        return result;
    }

}
