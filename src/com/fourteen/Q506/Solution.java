package com.fourteen.Q506;

import java.util.*;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/2 13:49
 */
public class Solution {

    public static void main(String[] args) {
        int[] s = {10,3,8,9,4};
        String[] relativeRanks = new Solution().findRelativeRanks(s);
        for (String relativeRank : relativeRanks) {
            System.out.println(relativeRank);
        }
    }

    public String[] findRelativeRanks(int[] score) {
        String[] str = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] res = null;
        if (score.length > 0) {
            res = new String[score.length];

            List<Integer> list = new ArrayList<>(score.length);
            for (int i : score) {
                list.add(i);
            }
            List<Integer> l = new ArrayList<>(list);

            Collections.sort(list, (o1, o2) -> o2-o1);


            for (int i = 0; i < l.size(); i++) {
                int index = l.indexOf(list.get(i));
                if (i < 3) {
                    res[index] = str[i];
                }else{
                    int t = i+1;
                    res[index] = String.valueOf(t);
                }
            }

        }
        return res;
    }
}
