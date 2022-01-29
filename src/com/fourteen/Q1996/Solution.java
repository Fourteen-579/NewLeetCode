package com.fourteen.Q1996;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/28 9:24
 */
public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{7,9},{10,7},{6,9},{10,4},{7,5},{7,10}, {1, 10}};
        System.out.println(new Solution().numberOfWeakCharacters(nums));
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int res = 0;

        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        int[] maxDefense = properties[0];
        for (int i = 1; i < properties.length; i++) {
            if (maxDefense[0] != properties[i][0] && properties[i][1] < maxDefense[1]) {
                res++;
            }
            if (maxDefense[1] < properties[i][1]) {
                maxDefense = properties[i];
            }
        }

        return res;
    }

}
