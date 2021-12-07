package com.fourteen.Q1034;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/7 13:51
 */
public class Solution {
    public static void main(String[] args) {
        int[][] g = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int row = 1, col = 1, color = 2;
        int[][] ints = new Solution().colorBorder(g, row, col, color);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int point = grid[row][col];
        if (point == color) {
            return grid;
        }
        int xLen = grid.length;
        int yLen = grid[0].length;

        int[][] res = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            res[i] = grid[i].clone();
        }

        boolean[][] flag = new boolean[xLen][yLen];

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{row, col});

        while (list.size() > 0) {
            int[] ints = list.get(0);
            int x = ints[0];
            int y = ints[1];
            list.remove(0);

            if (!flag[x][y]) {
                boolean t = (x + 1 < xLen && grid[x + 1][y] != point)
                        || (x - 1 >= 0 && grid[x - 1][y] != point)
                        || (y + 1 < yLen && grid[x][y + 1] != point)
                        || (y - 1 >= 0 && grid[x][y - 1] != point);
                if ((t || x == 0 || y == 0 || x == xLen - 1 || y == yLen - 1)) {
                    res[x][y] = color;
                }
                flag[x][y] = true;
                if (x + 1 < xLen && grid[x + 1][y] == point) {
                    list.add(new int[]{x + 1, y});
                }
                if (x - 1 >= 0 && grid[x - 1][y] == point) {
                    list.add(new int[]{x - 1, y});
                }
                if (y + 1 < yLen && grid[x][y + 1] == point) {
                    list.add(new int[]{x, y + 1});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == point) {
                    list.add(new int[]{x, y - 1});
                }
            }
        }
        return res;
    }

}
