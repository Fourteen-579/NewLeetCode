package com.fourteen.Q1535;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/21 13:12
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7};
        int k = 2;
        System.out.println(getWinner(arr, k));
    }

    public static int getWinner(int[] arr, int k) {

        if (arr.length - 1 <= k) {
            return Arrays.stream(arr).max().getAsInt();
        }

        Deque<Integer> deque = Arrays.stream(arr)
                .boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int win = deque.pollFirst();
        int winCount = 0;

        while (winCount < k) {
            Integer temp = deque.pollFirst();
            if (temp > win) {
                deque.offerLast(win);
                win = temp;
                winCount = 0;
            } else {
                deque.offerLast(temp);
            }
            winCount++;
        }

        return win;
    }

}
