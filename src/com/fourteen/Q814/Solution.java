package com.fourteen.Q814;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/7/21 8:56
 */


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

public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0, node1, node2);
        TreeNode root = new TreeNode(1, null, node3);
        new Solution().pruneTree(root);
    }

    public void search(TreeNode node) {
        if (node != null) {
            search(node.left);
            search(node.right);
            if (node.left != null && node.left.val == -1) {
                node.left = null;
            }
            if (node.right != null && node.right.val == -1) {
                node.right = null;
            }

            if (node.val == 0 && node.left == null && node.right == null) {
                node.val = -1;
            }
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        search(root);
        if (root.val == 0 && root.left == null && root.right == null) {
            root=null;
        }
        return root;
    }
}