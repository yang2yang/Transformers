package concurrent.producermodel.correct;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试目标，生产者线程生产100个数据，消费者线程消费100个数据，遇到0不再消费。最后保证资源为0。
 *
 * @author qingli.ding
 * @date 2019/7/25
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();

        Producer producer = new Producer(resource);
        ExecutorService producerExecutorService = Executors.newSingleThreadExecutor();
        producerExecutorService.submit((Runnable) () -> producer.producer());

//        Thread.sleep(5000);

        Consumer consumer = new Consumer(resource);
        ExecutorService consumerExecutorService = Executors.newSingleThreadExecutor();
        consumerExecutorService.submit((Runnable) () -> consumer.consumer());

        Thread.sleep(5000);
        System.out.println("最后Resource数量为" + resource.getI());
//        不知道为什么线程一直不结束
//        while (true) {
//            if (producerExecutorService.isTerminated() && consumerExecutorService.isTerminated()) {
//                System.out.println("最后Resource数量为" + resource.getI());
//                break;
//            }
//        }
        System.out.println("running is stoped");
    }
}
