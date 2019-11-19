package concurrent.lesson2;

public class SleepStateThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(60 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
