package com.fourteen.Q825;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/27 10:18
 */
public class Solution {
    public static void main(String[] args) {
        int[] ages = {16, 16};
        System.out.println(new Solution().numFriendRequests(ages));
    }


    public int numFriendRequests(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        int len = ages.length;
        int rightIndex = 0, leftIndex = 0;
        for (int i = 0; i < len; i++) {
            if (ages[i] < 15) {
                continue;
            }
            double a1 = 0.5 * ages[i] + 7;

            while (ages[leftIndex] <= a1) {
                leftIndex++;
            }
            while (rightIndex + 1 < len && ages[rightIndex + 1] <= ages[i]) {
                rightIndex++;
            }

            res += rightIndex - leftIndex;
        }
        return res;
    }
}
