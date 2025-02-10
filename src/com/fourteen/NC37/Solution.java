package com.fourteen.NC37;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2025/2/7 10:24
 */
public class Solution {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            return result;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval prev = result.get(result.size() - 1);
            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end);
            } else {
                result.add(curr);
            }
        }
        return result;
    }

}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
