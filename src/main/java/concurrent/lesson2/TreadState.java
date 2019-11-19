package concurrent.lesson2;

public class TreadState {
    public static void main(String[] args) throws InterruptedException {
        //当前线程的状态 RUNNABLE
        testCurrentThreadState();
        //打印调用sleep函数线程状态 TIMED_WAITING
        testSleepThreadState();
        //打印被syn阻塞的线程 BLOCK
        testSynThreadState();

    }

    private static void testSynThreadState() throws InterruptedException {
        SynAccount synAccount = new SynAccount();
        Thread blockStateThread = new Thread(new BlockStateThread(synAccount),"blockStateThread1");
        Thread blockStateThread2 = new Thread(new BlockStateThread(synAccount),"blockStateThread2");
        blockStateThread.start();
        blockStateThread2.start();
        Thread.sleep(1 * 1000);
        System.out.println("blockStateThread state:" + blockStateThread.getState());
        System.out.println("blockStateThread2 state:" + blockStateThread2.getState());
    }

    private static void testSleepThreadState() throws InterruptedException {
        Thread sleepStateThread = new Thread(new SleepStateThread(),"sleepStateThread");
        sleepStateThread.start();
        Thread.sleep(1 * 1000);
        System.out.println(sleepStateThread.getState());
    }

    private static void testCurrentThreadState() {
        System.out.println(Thread.currentThread().getState());
    }
}
