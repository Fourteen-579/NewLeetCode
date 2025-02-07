package com.fourteen.HJ33;

import java.util.Scanner;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/6 14:11
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String ip = in.next();
        String numIp = in.next();

        StringBuilder ipStr = new StringBuilder();
        String[] ipArr = ip.split("\\.");
        for (String s : ipArr) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(Integer.parseInt(s)));

            if (binaryString.length() < 8) {
                int diff = 8 - binaryString.length();
                for (int i = 0; i < diff; i++) {
                    binaryString.insert(0, "0");
                }
            }

            ipStr.append(binaryString);
        }

        System.out.println(Long.parseLong(ipStr.toString(), 2));

        StringBuilder binaryString = new StringBuilder(Long.toBinaryString(Long.parseLong(numIp)));
        if (binaryString.length() < 32) {
            int diff = 32 - binaryString.length();
            for (int i = 0; i < diff; i++) {
                binaryString.insert(0, "0");
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 8) {
            String sub = binaryString.substring(i, i + 8);
            int decimal = Integer.parseInt(sub, 2);
            result.append(decimal).append(".");
        }

        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

}
