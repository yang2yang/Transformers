package concurrent.producermodel.correct;

/**
 * 不停地往队列里面放入元素,放满了就不再放入了
 *
 * @author shane
 * @date 2019/7/25
 */
public class Producer {

    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    public Boolean producer() {
        for (int i = 0; i < 1000000; i++) {
            resource.producer();
        }
        System.out.println("producer done");
        return true;
    }

}
