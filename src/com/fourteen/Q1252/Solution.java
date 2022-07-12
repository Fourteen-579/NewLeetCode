package com.fourteen.Q1252;

public class Solution {
    public static void main(String[] args) {
        int m = 48, n = 37;
        int[][] indices = {{40, 5}};
        System.out.println(new Solution().oddCells(m, n, indices));
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
