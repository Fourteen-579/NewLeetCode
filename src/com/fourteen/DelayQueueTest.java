package com.fourteen;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();

        delayQueue.offer(new DelayTask("This is a delay 5s task", 5L));
        delayQueue.offer(new DelayTask("This is a delay 1s task", 1L));
        delayQueue.offer(new DelayTask("This is a delay 2s task", 2L));

        new Thread(()->{
            while (true) {
                try {
                    DelayTask task = delayQueue.take();
                    System.out.println("task:" + task.getTask());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

}

class DelayTask implements Delayed {

    String task;

    Long delayTaskTime;

    public String getTask() {
        return task;
    }

    public Long getDelayTaskTime() {
        return delayTaskTime;
    }

    public DelayTask(String task, Long delayTaskTime) {
        this.task = task;
        this.delayTaskTime = System.currentTimeMillis() + delayTaskTime * 1000;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(System.currentTimeMillis() - this.delayTaskTime, TimeUnit.SECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelayTaskTime() - ((DelayTask) o).getDelayTaskTime());
    }
}