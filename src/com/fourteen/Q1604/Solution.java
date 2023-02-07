package com.fourteen.Q1604;

import java.time.LocalTime;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/2/7 13:26
 */
public class Solution {
    public static void main(String[] args) {
        String[] keyName = {"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"};
        String[] keyTime = {"23:20", "11:09", "23:30", "23:02", "15:28", "22:57", "23:40", "03:43", "21:55", "20:38", "00:19"};

        List<String> strings = new Solution().alertNames(keyName, keyTime);
        strings.forEach(name -> {
            System.out.println(name);
        });
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();

        Map<String, List<LocalTime>> map = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String[] split = keyTime[i].split(":");
            LocalTime temp = LocalTime.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]));

            List<LocalTime> times = map.getOrDefault(keyName[i], new ArrayList<>());
            times.add(temp);

            map.put(keyName[i], times);
        }

        map.forEach((s, localTimes) -> {
            if (localTimes.size() >= 3) {
                localTimes.sort(Comparator.naturalOrder());

                int start = 0, end = 2;
                while (end < localTimes.size()) {
                    LocalTime startTime = localTimes.get(start);
                    LocalTime endTime = localTimes.get(end);


                    if (startTime.getHour() == endTime.getHour() || !startTime.plusHours(1).isBefore(endTime)) {
                        result.add(s);
                        break;
                    }
                    start++;
                    end++;
                }
            }
        });

        Collections.sort(result);
        return result;
    }
}
