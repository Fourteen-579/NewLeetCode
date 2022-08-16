package com.fourteen.Q641;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2022/8/15 13:33
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        list.add(1);
        list.add(1);
    }
}

class MyCircularDeque {

    List<Integer> list;

    int maxSize;

    public MyCircularDeque(int k) {
        list = new ArrayList<>(k);
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if (list.size() + 1 <= maxSize) {
            list.add(0, value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (list.size() + 1 <= maxSize) {
            list.add(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (list == null || list.isEmpty()) {
            return false;
        }

        list.remove(0);
        return true;
    }

    public boolean deleteLast() {
        if (list == null || list.isEmpty()) {
            return false;
        }
        list.remove(list.size() - 1);
        return true;
    }

    public int getFront() {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        return list.get(0);
    }

    public int getRear() {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list == null || list.isEmpty();
    }

    public boolean isFull() {
        return list != null && list.size() == maxSize;
    }
}
