package com.fourteen.Q77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/8 14:45
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combine(1, 1);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            res.add(list);
        } else {
            temp(n, k, 1, new ArrayList<>(), res);
        }
        return res;
    }

    private void temp(int n, int k, int index, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (index > n|| list.size() + (n - index + 1) < k) {
            return;
        }

        list.add(index);
        temp(n, k, index + 1, list, res);
        list.remove(list.size() - 1);
        temp(n, k, index + 1, list, res);
    }

}
