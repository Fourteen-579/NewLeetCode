package com.fourteen.Q807;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/13 9:26
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(new Solution().maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int[][] max = new int[2][length];
        for (int i = 0; i < length; i++) {
            max[0][i] = grid[i][0];
            max[1][i] = grid[0][i];
            for (int j = 0; j < length; j++) {
                max[1][i] = Math.max(max[1][i], grid[j][i]);
                max[0][i] = Math.max(max[0][i], grid[i][j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum += Math.min(max[0][i], max[1][j]) - grid[i][j];
            }
        }

        return sum;
    }
}
