package com.fourteen.Q838;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/21 10:15
 */
public class Solution {

    public static void main(String[] args) {
        String sre = ".L.R...LR..L..";
        System.out.println(new Solution().pushDominoes(sre));
    }

    public String pushDominoes(String dominoes) {
        StringBuffer str = new StringBuffer();

        char left = 'L';
        int leftIndex = 0;
        dominoes = 'L' + dominoes + 'R';
        for (int i = 1; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'L') {
                if (left == 'L') {
                    for (int j = leftIndex; j < i; j++) {
                        str.append('L');
                    }
                } else if (left == 'R') {
                    for (int j = leftIndex; j < (i + leftIndex) / 2; j++) {
                        str.append('R');
                    }
                    if ((i + leftIndex) % 2 == 0) {
                        str.append('.');
                    } else {
                        str.append('R');
                    }
                    for (int j = (i + leftIndex) / 2 + 1; j < i; j++) {
                        str.append('L');
                    }
                }
                left = 'L';
                leftIndex = i;
            } else if (dominoes.charAt(i) == 'R') {
                if (left == 'L') {
                    for (int j = leftIndex; j < i; j++) {
                        str.append(dominoes.charAt(j));
                    }
                } else if (left == 'R') {
                    for (int j = leftIndex; j < i; j++) {
                        str.append('R');
                    }
                }
                left = 'R';
                leftIndex = i;
            }
        }


        return str.deleteCharAt(0).toString();
    }
}
