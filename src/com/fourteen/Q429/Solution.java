package com.fourteen.Q429;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/19 10:54
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        hierarchicalSearch(root, result, 1);
        return result;
    }

    public void hierarchicalSearch(Node node, List<List<Integer>> array, Integer depth) {
        if (node == null) {
            return;
        }

        if (array.size() < depth) {
            array.add(new ArrayList<>());
        }

        List<Integer> list = array.get(depth - 1);
        list.add(node.val);

        if (node.children != null && !node.children.isEmpty()) {
            for (Node child : node.children) {
                hierarchicalSearch(child, array, depth + 1);
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
};
