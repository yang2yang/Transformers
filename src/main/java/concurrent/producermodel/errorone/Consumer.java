package concurrent.producermodel.errorone;

import java.util.Queue;

/**
 * 不停从队列里面取元素
 *
 * @author shane
 * @date 2019/7/25
 */
public class Consumer<E> {

    private Queue<E> queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public Boolean consumer() {
        queue.poll();
        return true;
    }
}
