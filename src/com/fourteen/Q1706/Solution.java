package com.fourteen.Q1706;

import java.util.Arrays;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/24 9:45
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(new Solution().findBall(grid)));
    }

    public int[] findBall(int[][] grid) {
        int length = grid.length;
        int[] res = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            int[] position = {i, 0};
            for (int j = 0; j < length; j++) {
                int y = position[0], x = position[1];
                if (grid[x][y] == 1) {
                    if (y + 1 >= grid[0].length || grid[x][y + 1] == -1) {
                        break;
                    }
                    position[0]++;
                } else if (grid[x][y] == -1) {
                    if (y - 1 < 0 || grid[x][y - 1] == 1) {
                        break;
                    }
                    position[0]--;
                }
                position[1]++;
            }
            if (position[1] == grid.length) {
                res[i] = position[0];
            } else {
                res[i] = -1;
            }
        }


        return res;
    }

}
