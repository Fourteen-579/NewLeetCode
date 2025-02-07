package com.fourteen.HJ5;

import java.util.Scanner;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/6 09:23
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        String next = in.next();
        int i = next.length() - 1;
        int j = 0;
        while (i > 1) {
            char c = next.charAt(i);
            int num = 0;
            if (c >= 'A' && c <= 'F') {
                num = c - 'A' + 10;
            } else {
                num = (int) c - '0';
            }

            result += num * Math.pow(16, j);
            i--;
            j++;
        }

        System.out.println(result);
    }

}
