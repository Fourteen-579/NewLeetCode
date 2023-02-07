package com.fourteen.Q1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/1/12 15:50
 */
public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        knowledge.forEach(item -> map.put(item.get(0), item.get(1)));




        return s;
    }
}
