package com.fourteen.Q1019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/11 16:09
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(5);
        ListNode node1 = new ListNode(1, node0);
        ListNode node2 = new ListNode(2, node1);

        System.out.println(Arrays.toString(new Solution().nextLargerNodes(node2)));
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{head.val, 0});

        ListNode nextNode = head.next;

        int index = 1;

        while (nextNode != null) {
            while (!stack.isEmpty() && stack.peek()[0] < nextNode.val) {
                list.set(stack.peek()[1], nextNode.val);
                stack.pop();
            }
            stack.push(new int[]{nextNode.val, index});

            index++;
            nextNode = nextNode.next;
            list.add(0);
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
