package com.fourteen.Q90;

import java.util.*;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/5 09:34
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().subsetsWithDup(new int[]{4,4,4,1,4});

        for (List<Integer> integers : result) {
            System.out.println(integers.toString());
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> exists = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();
        temp(result, new ArrayList<>(), nums, 0, exists);

        return result;
    }

    public void temp(List<List<Integer>> result, List<Integer> tempList, int[] nums, int i, Set<List<Integer>> exists) {
        if (i >= nums.length) {
            return;
        }

        ArrayList<Integer> add = new ArrayList<>(tempList);
        add.add(nums[i]);

        ArrayList<Integer> notAdd = new ArrayList<>(tempList);

        if (!exists.contains(add)) {
            result.add(add);
            exists.add(add);
        }
        if (!exists.contains(notAdd)) {
            result.add(notAdd);
            exists.add(notAdd);
        }

        temp(result, add, nums, i + 1, exists);
        temp(result, notAdd, nums, i + 1, exists);
    }

}
