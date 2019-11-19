package concurrent.lesson2;

public class BlockStateThread implements Runnable {

    public SynAccount synAccount;

    BlockStateThread (SynAccount synAccount) {
        this.synAccount = synAccount;
    }

    @Override
    public void run() {
        try {
            this.synAccount.transferIn(50.0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
