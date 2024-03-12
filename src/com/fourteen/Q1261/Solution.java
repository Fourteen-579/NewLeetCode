package com.fourteen.Q1261;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2024/3/12 9:57
 */
public class Solution {
}

class FindElements {

    Map<Integer, Integer> num;

    public FindElements(TreeNode root) {
        num = new HashMap<>();

        if (root != null) {
            root.val = 0;
            num.put(0, 0);
            leftMethod(root.left, root.val);
            rightMethod(root.right, root.val);
        }
    }

    private void leftMethod(TreeNode left, Integer parentVal) {
        if (left == null) {
            return;
        }

        left.val = parentVal * 2 + 1;
        num.put(left.val, left.val);

        leftMethod(left.left, left.val);
        rightMethod(left.right, left.val);
    }

    private void rightMethod(TreeNode right, Integer parentVal) {
        if (right == null) {
            return;
        }

        right.val = parentVal * 2 + 2;
        num.put(right.val, right.val);

        leftMethod(right.left, right.val);
        rightMethod(right.right, right.val);
    }

    public boolean find(int target) {
        return num.containsKey(target);
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
