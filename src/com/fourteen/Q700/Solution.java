package com.fourteen.Q700;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//public class Solution {
//    public TreeNode searchBST(TreeNode root, int val) {
//        TreeNode res = null;
//        while (root != null) {
//            if (root.val == val) {
//                res = root;
//                break;
//            } else if (root.val < val) {
//                root = root.right;
//            } else {
//                root = root.left;
//            }
//        }
//        return res;
//    }
//}
