package com.fourteen.Q1023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/14 10:38
 */
public class Solution {
    public static void main(String[] args) {
        String[] queries = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(Arrays.toString(new Solution().camelMatch(queries, pattern).toArray()));
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>(queries.length);

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            int index = 0;
            int j = 0;
            for (j = 0; j < query.length(); j++) {
                char queryChar = query.charAt(j);

                if (index < pattern.length()) {
                    if (pattern.charAt(index) == queryChar) {
                        index++;
                        continue;
                    }
                }

                if (queryChar >= 'a' && queryChar <= 'z') {
                    continue;
                } else {
                    break;
                }
            }
            if (index == pattern.length() && j == query.length()) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
