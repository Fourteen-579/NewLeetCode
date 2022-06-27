//package com.fourteen.Q513;
//
///**
// * @author fourteen_ksz
// * @version 1.0
// * @date 2022/6/27 14:22
// */
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
//
//    public void getResult(TreeNode node, Integer deep, int[] result) {
//        if (node == null) {
//            return;
//        }
//
//        if (node.left != null) {
//            if (result[1] < deep + 1) {
//                result[0] = node.left.val;
//                result[1] = deep + 1;
//            }
//        } else {
//            if (node.right != null && result[1] < deep + 1) {
//                result[0] = node.right.val;
//                result[1] = deep + 1;
//            }
//        }
//
//        getResult(node.left, deep + 1, result);
//        getResult(node.right, deep + 1, result);
//    }
//
//    public int findBottomLeftValue(TreeNode root) {
//        int[] result = new int[]{root.val, 0};
//
//        getResult(root, 0, result);
//        return result[0];
//    }
//}
