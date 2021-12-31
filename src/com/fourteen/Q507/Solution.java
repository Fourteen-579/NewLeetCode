package com.fourteen.Q507;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Ksz
 * @version 1.0
 * @date 2021/12/31 10:51
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        switch(num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }
}