package com.fourteen.Q423;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String str = "zerozero";
        System.out.println(new Solution().originalDigits(str));
    }

    public String originalDigits(String s) {
        StringBuffer res = new StringBuffer();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        String[][] str = {{"zero", "0"}, {"six", "6"}, {"two", "2"}, {"eight", "8"}, {"three", "3"}, {"seven", "7"}, {"five", "5"}, {"four", "4"}, {"nine", "9"}, {"one", "1"}};

        for (int k = 0; k < str.length; k++) {
            if (map.size() == 0) {
                break;
            }
            Map<Character, Integer> temp = new HashMap<>(map);

            int i = 0;
            while (true) {
                Character c = str[k][0].charAt(i);
                if (temp.size() > 0 && temp.get(c) != null && temp.get(c) > 0) {
                    if (temp.get(c) == 1) {
                        temp.remove(c);
                    } else {
                        temp.put(c, temp.get(c) - 1);
                    }
                    if (i + 1 == str[k][0].length()) {
                        res.append(str[k][1]);
                        map = new HashMap<>(temp);
                    }
                } else {
                    break;
                }
                i++;
                if (i == str[k][0].length()) {
                    i = 0;
                }
            }
        }

        char[] chars = res.toString().toCharArray();
        Arrays.sort(chars);
        StringBuffer r = new StringBuffer();
        for (char aChar : chars) {
            r.append(aChar);
        }
        return r.toString();
    }
}
