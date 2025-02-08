package com.fourteen.HJ10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/6 09:45
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= 127 && c >= 0) {
                set.add(c);
            }
        }
        System.out.println(set.size());
    }

}
