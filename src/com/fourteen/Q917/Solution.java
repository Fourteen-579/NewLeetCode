package com.fourteen.Q917;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksz
 * @version 1.0
 * @date 2022/2/23 9:55
 */
public class Solution {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q! ";
        System.out.println(new Solution().reverseOnlyLetters(s));
    }

    public String reverseOnlyLetters(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Integer> index = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') {
                stringBuffer.append(c);
            } else {
                index.add(i);
                characters.add(c);
            }
        }
        StringBuffer reverse = stringBuffer.reverse();
        for (int i = 0; i < index.size(); i++) {
            reverse.insert((int) index.get(i), (char) characters.get(i));
        }
        return reverse.toString();
    }

}
