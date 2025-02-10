package com.fourteen.Q994;

import java.util.Stack;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/7 11:04
 */
public class Solution {

    public int orangesRotting(int[][] grid) {
        int result = 0;

        Stack<int[]> stack = new Stack<>();
        int m = grid.length;
        int n = grid[0].length;
        int all = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    stack.push(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    all++;
                }
            }
        }

        while (!stack.isEmpty() && all != 0) {
            Stack<int[]> temp = new Stack<>();
            while (!stack.isEmpty() && all != 0) {
                int[] orange = stack.pop();
                int x = orange[0];
                int y = orange[1];

                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    all--;
                    grid[x - 1][y] = 2;
                    temp.push(new int[]{x - 1, y});
                }
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    all--;
                    grid[x + 1][y] = 2;
                    temp.push(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    all--;
                    grid[x][y - 1] = 2;
                    temp.push(new int[]{x, y - 1});
                }
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    all--;
                    grid[x][y + 1] = 2;
                    temp.push(new int[]{x, y + 1});
                }
            }
            stack = temp;
            result++;
        }

        return all == 0 ? result : -1;
    }

}
