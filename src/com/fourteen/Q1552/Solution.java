package com.fourteen.Q1552;

import java.util.Arrays;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/2/9 10:08
 */
public class Solution {
    public int maxDistance(int[] position, int m) {
        Integer result = 0;

        Arrays.sort(position);

        int range = (position[position.length - 1] - position[0] + 1) / m;

        return result;
    }
}
