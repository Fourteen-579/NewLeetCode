package com.fourteen;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/20 9:33
 */
public class StreamTest2 {
    public static void main(String[] args) {

        StreamTest streamTest = new StreamTest();

//        //map实例
//        streamTest.mapTest();
//
//        //flatMap实例
//        streamTest.flatMapTest();

//        //peek和foreach实例
//        streamTest.peekAndForeachTest();

//        //peek和map实例
//        streamTest.peekAndMapTest();

//        //流终止不可操作实例
//        streamTest.testHandleStreamAfterClosed();

//        //生成拼接字符串
//        streamTest.testForJoinStrings();

        //测试并行流
//        try {
//            streamTest.testForkJinTask();
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void mapTest() {
        List<String> ids = Arrays.asList("001", "002", "003", "004", "005");

        List<User> users = ids.stream().map(id -> {
            return new User(id);
        }).collect(Collectors.toList());

        System.out.println(users);
    }

    public void flatMapTest() {
        List<String> sentences = Arrays.asList("hello world", "Jia Gou Wu Dao");
        List<String> strings = sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList());
        System.out.println(strings);
    }

    public void peekAndForeachTest() {
        List<String> sentences = Arrays.asList("hello world", "Jia Gou Wu Dao");
        // 演示点1： 仅peek操作，最终不会执行
        System.out.println("----peek1----");
        sentences.stream().peek(sentence -> System.out.println(sentence));
        // 演示点2： 仅foreach操作，最终会执行
        System.out.println("----foreach----");
        sentences.stream().forEach(sentence -> System.out.println(sentence));
        // 演示点3： peek操作后面增加终止操作，peek会执行
        System.out.println("----peek2----");
        sentences.stream().peek(sentence -> System.out.println(sentence)).count();
    }

    public void peekAndMapTest(){
        Stream.of(1, 2, 3)
                .peek(e -> e = e + 1)
                .forEach(e -> System.out.println("peek :" + e));

        Stream.of(1, 2, 3)
                .map(e -> e = e + 1)
                .forEach(e -> System.out.println("map :" + e));
    }

    public void testGetTargetUsers() {
        List<String> ids = Arrays.asList("205","10","308","49","627","193","111", "193");
        // 使用流操作
        List<Dept> results = ids.stream()
                .filter(s -> s.length() > 2)
                .distinct()
                .map(Integer::valueOf)
                .sorted(Comparator.comparingInt(o -> o))
                .limit(3)
                .map(id -> new Dept(id))
                .collect(Collectors.toList());
        System.out.println(results);
    }

    public void testHandleStreamAfterClosed() {
        List<String> ids = Arrays.asList("205", "10", "308", "49", "627", "193", "111", "193");
        Stream<String> stream = ids.stream().filter(s -> s.length() > 2);
        // 统计stream操作后剩余的元素个数
        System.out.println(stream.count());
        // 判断是否有元素值等于205
        try {
            System.out.println(stream.anyMatch("205"::equals));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testCollectStopOptions() {
        List<Dept> ids = Arrays.asList(new Dept(17), new Dept(22), new Dept(23));
        // collect成list
        List<Dept> collectList = ids.stream().filter(dept -> dept.getId() > 20)
                .collect(Collectors.toList());
        System.out.println("collectList:" + collectList);
        // collect成Set
        Set<Dept> collectSet = ids.stream().filter(dept -> dept.getId() > 20)
                .collect(Collectors.toSet());
        System.out.println("collectSet:" + collectSet);
        // collect成HashMap，key为id，value为Dept对象
        Map<Integer, Dept> collectMap = ids.stream().filter(dept -> dept.getId() > 20)
                .collect(Collectors.toMap(Dept::getId, dept -> dept));
        System.out.println("collectMap:" + collectMap);
    }

    public void testForJoinStrings() {
        List<String> ids = Arrays.asList("205", "10", "308", "49", "627", "193", "111", "193");
        StringBuilder builder = new StringBuilder();
        for (String id : ids) {
            builder.append(id).append(',');
        }
        // 去掉末尾多拼接的逗号
        builder.deleteCharAt(builder.length() - 1);
        System.out.println("for after:" + builder);

        //String.join和stream
        List<User> users = Arrays.asList(new User("x-001"),new User("y-002"),new User("z-003"),new User("m-004"));
    }

    public void testNumberCalculate() {
        List<Integer> ids = Arrays.asList(10, 20, 30, 40, 50);
        // 计算平均值
        Double average = ids.stream().collect(Collectors.averagingInt(value -> value));
        System.out.println("average:" + average);
        // 数据统计信息
        IntSummaryStatistics summary = ids.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println("summary: " + summary);
    }

    public void testForkJinTask() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        ExecutorService executorService = new ThreadPoolExecutor(5,5,3L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));

        Adder adder1 = new Adder(0,100,forkJoinPool);
        Adder adder2 = new Adder(0,100,executorService);

        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(adder1);
        Future<Integer> submit = executorService.submit(adder2);

        System.out.println("forkJoinPool:"+forkJoinTask.get());
        System.out.println("threadPool:"+submit.get());
    }

    public List<String> sortGetTop3LongWords(String sentence) {
        // 先切割句子，获取具体的单词信息
        String[] words = sentence.split(" ");
        List<String> wordList = new ArrayList<>();
        // 循环判断单词的长度，先过滤出符合长度要求的单词
        for (String word : words) {
            if (word.length() > 5) {
                wordList.add(word);
            }
        }
        // 对符合条件的列表按照长度进行排序
        wordList.sort((o1, o2) -> o2.length() - o1.length());
        // 判断list结果长度，如果大于3则截取前三个数据的子list返回
        if (wordList.size() > 3) {
            wordList = wordList.subList(0, 3);
        }
        return wordList;
    }

    public List<String> sortGetTop3LongWordsByStream(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .filter(word -> word.length() > 5)
                .sorted((o1, o2) -> o2.length() - o1.length())
                .limit(3)
                .collect(Collectors.toList());
    }

}
