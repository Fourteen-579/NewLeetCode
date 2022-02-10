package com.fourteen.Q884;

import java.util.*;
import java.util.function.Function;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/1/30 10:50
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "xfj vcahm vcahm frkqt oibcc jko oibcc frkqt ft tr";
        String s2 = "lv ktx ktx tr x xfj xfj frkqt ktx ta tr yynk vcahm";
        System.out.println(Arrays.toString(new Solution().uncommonFromSentences(s1, s2)));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> res = new ArrayList<>();

        StringBuffer str = new StringBuffer(s1+" "+s2);
        Set<String> set = new HashSet<>();
        String[] strings = str.toString().split(" ");
        for (String string : strings) {
            if (set.contains(string)) {
                res.remove(string);
            } else {
                res.add(string);
                set.add(string);
            }
        }

        return res.toArray(new String[res.size()]);
    }

}
