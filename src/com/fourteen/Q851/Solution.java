package com.fourteen.Q851;

import java.util.*;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/15 9:22
 */
public class Solution {

    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        System.out.println(Arrays.toString(new Solution().loudAndRich(richer, quiet)));
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (int[] ints : richer) {
            int poor = ints[1];
            int rich = ints[0];
            if (map.containsKey(poor)) {
                List<Integer> temp = map.get(poor);
                temp.add(rich);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(rich);
                map.put(poor, temp);
            }

            if (map2.containsKey(rich)) {
                List<Integer> temp = map2.get(rich);
                temp.add(poor);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(poor);
                map2.put(rich, temp);
            }

            if (map2.containsKey(poor)) {
                List<Integer> integers = map2.get(poor);
                for (Integer integer : integers) {
                    if (integer != poor) {
                        List<Integer> integers1 = map.get(integer);
                        integers1.add(rich);
                    }
                }
            }

            if (map.containsKey(rich)) {
                List<Integer> integers = map.get(rich);
                for (Integer integer : integers) {
                    if (integer != rich) {
                        List<Integer> integers1 = map2.get(integer);
                        integers1.add(poor);
                    }
                }
            }


        }

        int[] res = new int[quiet.length];

        for (int i = 0; i < res.length; i++) {
            List<Integer> list = map.get(i);
            if (list != null && list.size() > 0) {
                list.add(i);
                List<Integer> temp = new ArrayList<>(list.size());
                for (Integer integer : list) {
                    temp.add(quiet[integer]);
                }
                Integer min = Collections.min(temp);
                res[i] = temp.indexOf(min);
            } else {
                res[i] = i;
            }
        }
        return res;
    }

}
