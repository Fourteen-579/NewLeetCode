package com.fourteen.Q106;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/2/21 9:16
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return null;
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
