package com.fourteen.Q1656;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/8/16 9:12
 */
public class Solution {
    public static void main(String[] args) {
        String[] attay = new String[5];
        attay[3] = "10";
        System.out.println(Arrays.toString(attay));
    }
}

class OrderedStream {

    String[] array = null;
    int index = 0;

    public OrderedStream(int n) {
        array = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();

        array[idKey - 1] = value;

        if (idKey == index + 1) {
            while (index < array.length && array[index] != null) {
                result.add(array[index]);
                index++;
            }
        }

        return result;
    }
}