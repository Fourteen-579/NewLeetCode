package com.fourteen.Q748;

import java.util.*;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/10 11:08
 */
public class Solution {

    public static void main(String[] args) {
        String l = "iMSlpe4";
        String[] word = {"claim","consumer","student","camera","public","never","wonder","simple","thought","use"};
        System.out.println(new Solution().shortestCompletingWord(l, word));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            Character c = licensePlate.charAt(i);
            if (c <= 'z' && c >= 'a') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        Integer[] nums = new Integer[words.length];
        Arrays.fill(nums, -1);
        Set<Character> keySet = map.keySet();
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                Character c = words[i].charAt(j);
                if (temp.containsKey(c)) {
                    temp.put(c, temp.get(c) + 1);
                } else {
                    temp.put(c, 1);
                }
            }

            int finalI = i;
            map.forEach((character, integer) -> {
                if (nums[finalI] != 0) {
                    if (temp.containsKey(character) && temp.get(character) >= integer) {
                        nums[finalI] = words[finalI].length();
                    } else {
                        nums[finalI] = 0;
                    }
                }

            });
        }
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                min = min!=-1&&nums[min] <= nums[i] ? min : i;
            }
        }
        return words[min];
    }
}