package com.fourteen.HJ3;

import java.util.*;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/6 09:35
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            set.add(in.nextInt());
        }

        List<Integer> result = new ArrayList<>(set);
        result.sort(Integer::compareTo);

        for (Integer i : result) {
            System.out.println(i);
        }
    }

}
