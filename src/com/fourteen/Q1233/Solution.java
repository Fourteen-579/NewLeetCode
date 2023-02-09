package com.fourteen.Q1233;

import java.util.*;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/2/8 9:16
 */
public class Solution {
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(Arrays.toString(folder[3].split("/")));

    }

    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();

        TriNode top = new TriNode('/', new HashMap<>());

        TriNode node = top;

        for (String s : folder) {
            String[] strings = s.split("/");
            for (int i = 1; i < strings.length; i++) {
                if (node.getMap().containsKey(strings[i])) {
                    node = node.getMap().get(strings[i]);
                }
            }
        }


        return result;
    }

}

class TriNode {
    private Character c;
    private Map<Character, TriNode> map;

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public Map<Character, TriNode> getMap() {
        return map;
    }

    public void setMap(Map<Character, TriNode> map) {
        this.map = map;
    }

    public TriNode() {
    }

    public TriNode(Character c, Map<Character, TriNode> map) {
        this.c = c;
        this.map = map;
    }
}
