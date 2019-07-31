package concurrent.producermodel.errorone;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author qingli.ding
 * @date 2019/7/25
 */
public class Test {
    public static void main(String[] args) {
        Queue queue = new ArrayDeque();

        Producer producer = new Producer(queue);
        ExecutorService producerExecutorService = Executors.newSingleThreadExecutor();
        producerExecutorService.submit((Runnable) () -> producer.producer(1));

        Consumer consumer = new Consumer(queue);
        ExecutorService consumerExecutorService = Executors.newSingleThreadExecutor();
        consumerExecutorService.submit((Runnable) () -> consumer.consumer());
    }
}
