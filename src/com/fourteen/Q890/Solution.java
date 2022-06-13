package com.fourteen.Q890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/6/13 16:21
 */
class Solution {

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String p ="abb";
        List<String> andReplacePattern = new Solution().findAndReplacePattern(words, p);
        andReplacePattern.forEach(s -> System.out.println(s));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();

            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);

                if (map.containsKey(p)) {
                    if (!map.get(p).equals(w)) {
                        break;
                    }
                } else if(map2.containsKey(w)){
                    if(!map2.get(w).equals(p)){
                        break;
                    }
                }else{
                    map.put(p, w);
                    map2.put(w,p);
                }

                if (i == word.length() - 1) {
                    result.add(word);
                }
            }
        }

        return result;
    }
}
