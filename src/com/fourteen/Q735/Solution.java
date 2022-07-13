package com.fourteen.Q735;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/7/13 9:01
 */
public class Solution {
    public static void main(String[] args) {
        int[] s = new int[]{2, -2};
        System.out.println(Arrays.toString(new Solution().asteroidCollision(s)));
    }

    public boolean isPush(Stack<Integer> stack, int asteroid) {
        if (stack.isEmpty() || (asteroid > 0 && stack.peek() > 0)
                || (stack.peek() < 0 && asteroid < 0) || (asteroid > 0 && stack.peek() < 0)) {
            return true;
        } else {
            return false;
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (isPush(stack, asteroid)) {
                stack.push(asteroid);
            } else {
                int flag = 0;
                while (!stack.isEmpty() && !isPush(stack, asteroid) && Math.abs(stack.peek()) <= Math.abs(asteroid)) {
                    if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                        stack.pop();
                        flag = 1;
                    } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                        stack.pop();
                        flag = 2;
                        break;
                    }
                }
                if ((stack.isEmpty() && flag == 1) || (isPush(stack, asteroid) && flag != 2)) {
                    stack.push(asteroid);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}