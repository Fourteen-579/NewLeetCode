package com.fourteen.Q1705;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/24 9:24
 */
public class Solution {

    public static void main(String[] args) {
        int[] apple = {3,0,0,0,0,2};
        int[] day = {3,0,0,0,0,2};
        System.out.println(new Solution().eatenApples(apple, day));
    }

    public int eatenApples(int[] apples, int[] days) {
        int eat = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < apples.length || list.size() > 0; i++) {
            //如果当天没有之前剩余的苹果则需要先吃一个
            if (i < apples.length && list.size() == 0 && apples[i] > 0) {
                apples[i]--;
                eat++;
                if (apples[i] > 0) {
                    list.add(i);
                }
                continue;
            }
            if (list.size() > 0 && days[list.get(0)] + list.get(0) <= i) {
                for (int i1 = 0; i1 < list.size(); i1++) {
                    if (days[list.get(i1)] + list.get(i1) <= i) {
                        list.remove(list.get(i1));
                        i1--;
                    } else {
                        break;
                    }
                }
            }

            if (i < apples.length && apples[i] > 0) {
                int endDay = i + days[i];
                if (list.size() > 0) {
                    for (int j = 0; j < list.size(); j++) {
                        if (endDay <= days[list.get(j)] + list.get(j)) {
                            list.add(j, i);
                            break;
                        }
                    }
                }
                if (apples[i] > 0) {
                    list.add(i);
                }
            }
            if (list.size() > 0) {
                Integer integer = list.get(0);
                if (apples[integer] == 1) {
                    list.remove(0);
                }
                apples[integer]--;
                eat++;
            }
        }

        return eat;
    }

}
