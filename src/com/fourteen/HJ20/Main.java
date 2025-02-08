package com.fourteen.HJ20;

import java.util.Scanner;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/6 13:49
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int b = 0;
        int s = 0;
        int num = 0;
        int ts = 0;

        while (in.hasNext()) {
            String str = in.next();

            if (str.length() < 8) {
                System.out.println("NG");
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    s = 1;
                } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    b = 1;
                } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    num = 1;
                } else {
                    ts = 1;
                }
            }

            int count = s + b + num + ts;
            b = 0;
            s = 0;
            num = 0;
            ts = 0;
            if (count < 3) {
                System.out.println("NG");
                continue;
            }

            boolean flag = false;
            for (int i = 0; i < str.length() - 3; i++) {
                String text = str.substring(i, i + 3);
                for (int j = i + 2; j < str.length() - 3; j++) {
                    String text2 = str.substring(j, j + 3);
                    if (text.equals(text2)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                System.out.println("NG");
                continue;
            }

            System.out.println("OK");
        }
    }

}
