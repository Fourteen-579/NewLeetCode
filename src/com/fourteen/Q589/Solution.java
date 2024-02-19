package com.fourteen.Q589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/19 11:06
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            deepSearch(root, result);
        }
        return result;
    }

    public void deepSearch(Node node, List<Integer> list) {
        list.add(node.val);

        if (node.children == null || node.children.isEmpty()) {
            return;
        }

        for (Node child : node.children) {
            if (child != null) {
                deepSearch(child, list);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}