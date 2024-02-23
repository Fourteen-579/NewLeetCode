package com.fourteen.Q2583;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/23 14:21
 */
public class Solution {

    public static void main(String[] args) {

    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> array = new ArrayList<>();
        search(root, array, 0);

        array.sort(Long::compare);

        if (array.size() < k) {
            return -1;
        }

        return array.get(array.size() - k);
    }

    private void search(TreeNode node, List<Long> array, int depth) {
        if (node == null) {
            return;
        }

        if (array.size() <= depth) {
            array.add(0L);
        }

        array.set(depth, array.get(depth) + node.val);

        if (node.left != null) {
            search(node.left, array, depth + 1);
        }

        if (node.right != null) {
            search(node.right, array, depth + 1);
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