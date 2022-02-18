package com.fourteen.Q1791;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/18 9:29
 */
public class Solution {
    public int findCenter(int[][] edges) {
        int res = 0;

        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            res = edges[0][0];
        } else if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1]) {
            res = edges[0][1];
        }

        return res;
    }
}
