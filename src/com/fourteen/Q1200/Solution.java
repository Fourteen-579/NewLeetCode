package com.fourteen.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/7/4 13:53
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> lists = new Solution().minimumAbsDifference(arr);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int abs = Math.abs(arr[i] - arr[i + 1]);
            if (min > abs) {
                min = abs;
                result.clear();
            } else if (min < abs) {
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            temp.add(arr[i + 1]);
            result.add(temp);
        }

        return result;
    }
}
