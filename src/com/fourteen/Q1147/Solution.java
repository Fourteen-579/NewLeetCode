package com.fourteen.Q1147;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/12 9:29
 */
public class Solution {
    public static void main(String[] args) {
        String text = "bbbbb";
        System.out.println(new Solution().longestDecomposition(text));
    }

    public int longestDecomposition(String text) {
        int result = 0;

        char[] chars = text.toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();

        int preIndex = 0, nextIndex = chars.length - 1;

        while (preIndex <= nextIndex && preIndex < chars.length && nextIndex >= 0) {
            stack.push(chars[preIndex]);
            deque.addFirst(chars[nextIndex]);

            boolean equals = stack.toString().equals(deque.toString());
            if (equals && preIndex != nextIndex) {
                result += 2;
                stack.clear();
                deque.clear();
            } else if (equals && preIndex == nextIndex) {
                result++;
                stack.clear();
                deque.clear();
            }

            preIndex++;
            nextIndex--;
        }

        if (!stack.isEmpty()) {
            result++;
        }

        return result;
    }
}
