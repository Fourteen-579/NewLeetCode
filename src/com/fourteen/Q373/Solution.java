package com.fourteen.Q373;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/14 9:28
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 11};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> lists = new Solution().kSmallestPairs(nums1, nums2, 3);
        lists.forEach(item -> System.out.println(item));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>(k);

        
        return res;
    }

}
