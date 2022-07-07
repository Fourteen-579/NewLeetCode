package com.fourteen.Q648;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author fourteen_ksz
 * @version 1.0
 * @date 2022/7/7 13:15
 */
public class Solution {
    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add("a");
        d.add("b");

        d.add("c");

        String s = "aadsfasf absbs bbab cadsfafs";

        System.out.println(new Solution().replaceWords(d,s));
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] split = sentence.split(" ");

        for (int i = 0; i < split.length; i++) {
            int finalI = i;
            dictionary.forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    if(split[finalI].startsWith(s)){
                        split[finalI] = s;
                    }
                }
            });
        }

        String result = "";
        for (int i = 0; i < split.length; i++) {
            result+=split[i];
            if(i!=split.length-1){
                result+=" ";
            }
        }

        return result;
    }
}
