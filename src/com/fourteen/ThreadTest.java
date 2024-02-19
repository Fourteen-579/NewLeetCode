package com.fourteen;

import java.util.concurrent.*;

/**
 * @author Fourteen_ksz
 * @version 1.0
 * @date 2023/4/28 9:24
 */
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("testThread groupName:" + Thread.currentThread().getThreadGroup().getName());

            System.out.println("testThread threadName:" + Thread.currentThread().getName());
        });

        thread.start();
        System.out.println("mainThread groupName:" + Thread.currentThread().getThreadGroup().getName());

        System.out.println("mainThread threadName:" + Thread.currentThread().getName());
    }

}


class ThreadTest2 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":This is Thread2");
    }

}

class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class CallTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return Thread.currentThread().getName() + " success!";
    }
}

class FutureTaskTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "FutureTask Test!";
    }
}
