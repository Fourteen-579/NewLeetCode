package com.fourteen.NC68;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/7 9:38
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jumpFloor(7));
    }

    public int jumpFloor(int number) {
        return jump(0, number);
    }

    public int jump(int current, int number) {
        if (current == number) {
            return 1;
        } else if (current > number) {
            return 0;
        }

        return jump(current + 1, number) + jump(current + 2, number);
    }

}
