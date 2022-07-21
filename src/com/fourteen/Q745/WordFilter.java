package com.fourteen.Q745;

import java.util.UUID;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/7/14 9:02
 */
public class WordFilter {

    public static void main(String[] args) {
//        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
//        int f = wordFilter.f("a", "e");
//        System.out.println(f);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }

    String[] object;

    public WordFilter(String[] words) {
        this.object = words.clone();
    }

    public int f(String pref, String suff) {
        int result = -1;

        for (int i = object.length - 1; i >= 0; i--) {
            if (object[i].startsWith(pref) && object[i].endsWith(suff)) {
                result = i;
                break;
            }
        }

        return result;
    }
}