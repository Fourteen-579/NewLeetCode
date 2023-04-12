package com.fourteen.Q2399;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/11 17:29
 */
public class Solution {
    public static void main(String[] args) {
        int[] dis = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String s = "abaccb";
        System.out.println(new Solution().checkDistances(s,dis));
    }
    public boolean checkDistances(String s, int[] distance) {

        for (int i = 0; i < distance.length; i++) {
            char c = (char) ('a' + i);

            int startIndex = s.indexOf(c);
            if (startIndex >= 0) {
                int endIndex = s.indexOf(c, startIndex + 1);
                if (endIndex - startIndex - 1 != distance[i]) {
                    return false;
                }
            }

        }

        return true;
    }
}
