package com.fourteen.Q1380;

import java.util.*;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/18 9:34
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix ={{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(new Solution().luckyNumbers(matrix).toArray().toString());
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                temp.add(matrix[j][i]);
            }
            array.add(temp);
        }

        for (int[] ints : matrix) {
            int minRow = Arrays.stream(ints).min().getAsInt();
            for (int i = 0; i < ints.length; i++) {
                if (minRow == ints[i]) {
                    List<Integer> integers = array.get(i);
                    Integer maxCol = integers.stream().max(Comparator.comparingInt(o -> o)).get();
                    if (maxCol == minRow) {
                        res.add(maxCol);
                    }
                    break;
                }
            }
        }


        return res;
    }
}
