package com.fourteen.Q9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(123));
    }

    public boolean isPalindrome(int x) {
        boolean flag = false;
        if (x >= 10) {
            List<Integer> list = new ArrayList<>();
            int base = 10;
            int temp = x;
            while (temp != 0) {
                list.add(temp % base);
                temp = temp / base;
            }
            int r = 0;
            Collections.reverse(list);
            base = 1;
            for (Integer integer : list) {
                r += integer * base;
                base *= 10;
            }
            if (r == x) {
                flag = true;
            }
        } else if (x >= 0) {
            flag = true;
        }
        return flag;
    }
}
