package com.fourteen.Q1765;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/29 9:29
 */
public class Solution {

    static class Temp {
        int i;
        int j;

        public Temp(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Temp temp = (Temp) o;
            return i == temp.i && j == temp.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static void main(String[] args) {
        int[][] isWater = {{0, 1}, {0, 0}};
        new Solution().highestPeak(isWater);
    }

    public void setNum(int i, int j, int[][] res, int[][] isWater, Set<Temp> set) {
        if (i - 1 >= 0 && isWater[i - 1][j] == 0 && res[i - 1][j] == 0) {
            res[i - 1][j] = res[i][j] + 1;
            set.add(new Temp(i - 1, j));
        }
        if (i + 1 < isWater.length && isWater[i + 1][j] == 0 && res[i + 1][j] == 0) {
            res[i + 1][j] = res[i][j] + 1;
            set.add(new Temp(i + 1, j));
        }
        if (j - 1 >= 0 && isWater[i][j - 1] == 0 && res[i][j - 1] == 0) {
            res[i][j - 1] = res[i][j] + 1;
            set.add(new Temp(i, j - 1));
        }
        if (j + 1 < isWater[0].length && isWater[i][j + 1] == 0 && res[i][j + 1] == 0) {
            res[i][j + 1] = res[i][j] + 1;
            set.add(new Temp(i, j + 1));
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        Set<Temp> set = new HashSet<>();
        int len1 = isWater.length;
        int len2 = isWater[0].length;
        int[][] res = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (isWater[i][j] == 1) {
                    setNum(i, j, res, isWater, set);
                }
            }
        }

        while (!set.isEmpty()) {
            Set<Temp> newSet = new HashSet<>();
            Set<Temp> finalSet = newSet;
            set.forEach(item -> {
                int i = item.i, j = item.j;
                setNum(i, j, res, isWater, finalSet);
            });
            set = newSet;
        }
        return res;
    }

}
