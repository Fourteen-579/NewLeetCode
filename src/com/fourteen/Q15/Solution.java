package com.fourteen.Q15;

import java.util.*;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/7/15 17:13
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        lists.forEach(list -> {
            System.out.println(Arrays.toString(list.toArray()));
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = null;

        if (nums.length < 3) {
            return result;
        }


        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int i1 = i + 1; i1 < nums.length - 1; i1++) {
                int temp = -(nums[i] + nums[i1]);
                int searchIndex = Arrays.binarySearch(nums, temp);
                if (searchIndex >= 0 && searchIndex != i && searchIndex != i1) {
                    if (!map.isEmpty() && map.get(nums[i]) != null) {
                        List<Integer> integers = map.get(nums[i]);
                        boolean contains = integers.contains(nums[i1]);
                        if (!contains) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[i1]);
                            list.add(nums[searchIndex]);
                            integers.add(nums[i1]);
                        }
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[i1]);
                        list.add(nums[searchIndex]);
                    }

                }
            }
        }

        return result;
    }
}
