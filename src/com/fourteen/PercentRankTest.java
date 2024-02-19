package com.fourteen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/5/9 19:20
 */
public class PercentRankTest {

    private List<Integer> arrays;

    private Integer maxNum;

    private BigDecimal arraysSize;

    public PercentRankTest(List<Integer> arrays) {
        Collections.sort(arrays);
        this.maxNum = arrays.get(arrays.size() - 1);

        List<Integer> sortedList = arrays.stream()
                .filter(nums -> !nums.equals(maxNum))
                .collect(Collectors.toList());
        this.arrays = sortedList;

        this.arraysSize = new BigDecimal(this.arrays.size());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList( 0, 1, 1, 5, 6, 7, 8, 9);

        PercentRankTest rankTest = new PercentRankTest(list);

        System.out.println(rankTest.calculatePercentile(8));
//        list.forEach(i -> System.out.println(rankTest.calculatePercentile(i)));

    }

    /**
     * 计算某个数字在一个数字列表中的分位数
     *
     * @param number 需要计算分位数的数字
     * @return
     */
    public BigDecimal calculatePercentile(Integer number) {
        if (number.equals(maxNum)) {
            return new BigDecimal(1).setScale(3);
        }

        // 计算数字在排序后的列表中的位置
        int position = arrays.indexOf(number);

        // 计算分位数
        BigDecimal percentile = new BigDecimal(position)
                .divide(arraysSize, 3, RoundingMode.DOWN);

        return percentile;
    }

}
