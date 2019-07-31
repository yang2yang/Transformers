package concurrent.producermodel.correct;

/**
 * @author qingli.ding
 * @date 2019/7/25
 */
public class Resource {

    private Integer i = 0;

    private Integer minSize = 0;

    private Integer maxSize = 100;

    public synchronized Boolean producer() {
        try {
            if (i.equals(maxSize)) {
                wait();
            }
            i++;
            notify();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized Boolean consumer() {
        try {
            if (i.equals(minSize)) {
                wait();
            }
            i--;
            notify();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
