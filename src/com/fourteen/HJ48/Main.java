package com.fourteen.HJ48;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/7 13:19
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int head = in.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(head);

        for (int i = 1; i < count; i++) {
            int num = in.nextInt();
            int node = in.nextInt();

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == node) {
                    list.add(j + 1, num);
                    break;
                }
            }
        }

        int deleteNum = in.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == deleteNum) {
                list.remove(i);
                break;
            }
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

}
