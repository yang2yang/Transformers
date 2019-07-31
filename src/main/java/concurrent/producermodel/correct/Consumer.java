package concurrent.producermodel.correct;

/**
 * 不停从队列里面取元素
 *
 * @author shane
 * @date 2019/7/25
 */
public class Consumer {

    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    public Boolean consumer() {
        for (int i = 0; i < 1000000; i++) {
            resource.consumer();
        }
        System.out.println("consumer done");
        return true;
    }
}
