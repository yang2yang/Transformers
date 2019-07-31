package concurrent.producermodel.errorone;

import java.util.Queue;

/**
 * 不停地往队列里面放入元素,放满了就不再放入了
 * @author shane
 * @date 2019/7/25
 */
public class Producer<E> {

    private Queue<E> queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public Boolean producer(E e) {
        queue.add(e);
        return true;
    }

}
