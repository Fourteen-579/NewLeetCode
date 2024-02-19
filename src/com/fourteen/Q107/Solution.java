package com.fourteen.Q107;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/19 11:09
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            hierarchicalSearch(root, result, 1);
            result = reversal(result);
        }
        return result;
    }

    public <T> List<T> reversal(List<T> array) {
        List<T> newArrays = new ArrayList<>();

        for (int i = array.size() - 1; i >= 0; i--) {
            newArrays.add(array.get(i));
        }

        return newArrays;
    }

    public void hierarchicalSearch(TreeNode node, List<List<Integer>> array, Integer depth) {
        if (array.size() < depth) {
            array.add(new ArrayList<>());
        }

        List<Integer> list = array.get(depth - 1);
        list.add(node.val);

        if (node.left != null) {
            hierarchicalSearch(node.left, array, depth + 1);
        }

        if (node.right != null) {
            hierarchicalSearch(node.right, array, depth + 1);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
