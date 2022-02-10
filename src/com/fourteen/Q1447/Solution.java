package com.fourteen.Q1447;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/10 10:01
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().simplifiedFractions(4);
    }

    public int isSimple(int mother, int son) {
        if (mother % son == 0 || son == 1) {
            return son;
        }
        return isSimple(son, mother % son);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();

        for (int i = n; i > 1; i--) {
            for (int j = 1; j <= i - 1; j++) {
                if (isSimple(i, j) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }

        return res;
    }

}
