package com.fourteen.Q515;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author fourteen_ksz
// * @version 1.0
// * @date 2022/6/26 17:05
// */
//
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
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        System.out.println(list.size());
//    }
//
//    public void read(TreeNode node, int deep, List<Integer> list) {
//        if (node == null) {
//            return;
//        }
//        if (list.size() < deep + 1) {
//            list.add(Integer.MIN_VALUE);
//        }
//        if (node.val > list.get(deep)) {
//            list.set(deep, node.val);
//        }
//        if (node.left != null) {
//            read(node.left, deep + 1, list);
//        }
//        if (node.right != null) {
//            read(node.right, deep + 1, list);
//        }
//    }
//
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//
//        read(root, 0, list);
//        return list;
//    }
//}
