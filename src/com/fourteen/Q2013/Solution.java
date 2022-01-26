package com.fourteen.Q2013;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/26 9:51
 */
public class Solution {
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{5, 10});
        detectSquares.add(new int[]{10, 5});
        detectSquares.add(new int[]{10, 10});
        detectSquares.add(new int[]{3, 0});
        detectSquares.add(new int[]{8, 0});
        detectSquares.add(new int[]{8, 5});
        detectSquares.add(new int[]{9, 0});
        detectSquares.add(new int[]{9, 8});
        detectSquares.add(new int[]{1, 8});
        detectSquares.add(new int[]{0, 0});
        detectSquares.add(new int[]{8, 0});
        detectSquares.add(new int[]{8, 8});
        detectSquares.add(new int[]{1, 9});
        detectSquares.add(new int[]{2, 9});
        detectSquares.add(new int[]{2, 10});
        detectSquares.add(new int[]{7, 8});
        detectSquares.add(new int[]{2, 3});
        detectSquares.add(new int[]{2, 8});
        detectSquares.add(new int[]{9, 10});
        detectSquares.add(new int[]{9, 5});
        detectSquares.add(new int[]{4, 5});
        detectSquares.add(new int[]{0, 9});
        detectSquares.add(new int[]{4, 5});
        detectSquares.add(new int[]{4, 9});
        detectSquares.add(new int[]{1, 10});
        detectSquares.add(new int[]{10, 1});
        detectSquares.add(new int[]{10, 10});
        detectSquares.add(new int[]{10, 0});
        detectSquares.add(new int[]{2, 0});
        detectSquares.add(new int[]{2, 8});
        detectSquares.add(new int[]{7, 6});
        detectSquares.add(new int[]{4, 6});
        detectSquares.add(new int[]{4, 9});
        detectSquares.add(new int[]{10, 9});
        detectSquares.add(new int[]{10, 0});
        detectSquares.add(new int[]{1, 0});
//        detectSquares.add(new int[]{0, 9});
//        detectSquares.add(new int[]{8, 1});
//        detectSquares.add(new int[]{0, 1});
//        detectSquares.add(new int[]{3,9});
//        detectSquares.add(new int[]{10,9});
//        detectSquares.add(new int[]{3,2});
        int count = detectSquares.count(new int[]{1, 9});
        System.out.println(count);
    }
}

class DetectSquares {

    Map<Integer, List<int[]>> xMap;
    int[][] map;

    public DetectSquares() {
        xMap = new HashMap<>();
        map = new int[1001][1001];
    }

    public void add(int[] point) {
        map[point[0]][point[1]] += 1;

        List<int[]> ints = xMap.computeIfAbsent(point[0], integer -> new ArrayList<>());
        ints.add(point);
    }

    public int count(int[] point) {
        AtomicInteger res = new AtomicInteger();

        List<int[]> xList = xMap.get(point[0]);
        if (xList != null && !xList.isEmpty()) {
            xList.forEach(xPoint -> {
                if (xPoint[0] != point[0] || xPoint[1] != point[1]) {
                    int length = Math.abs(xPoint[1] - point[1]);
                    if (point[0] + length <= 1000) {
                        int l = map[point[0] + length][point[1]];
                        res.addAndGet(l * map[point[0] + length][xPoint[1]]);
                    }
                    if (point[0] - length >= 0) {
                        int l2 = map[point[0] - length][point[1]];
                        res.addAndGet(l2 * map[point[0] - length][xPoint[1]]);
                    }
                }
            });
        }

        return res.get();
    }
}