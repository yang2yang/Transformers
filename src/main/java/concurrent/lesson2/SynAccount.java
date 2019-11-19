package concurrent.lesson2;

/**
 * 演示：增加了syn后的账户类
 * 账户
 */
public class SynAccount {

    /**
     * 余额
     */
    private Double balance;

    SynAccount() {
        balance = 0.;
    }

    /**
     * 转入
     * @param money
     * @return
     */
    public synchronized Double transferIn(Double money) throws InterruptedException {
        this.balance = balance + money;
        Thread.sleep(60 * 1000);
        return balance;
    }

    /**
     * 转出
     * @param money
     * @return
     */
    public synchronized Double transferOut(Double money) {
        this.balance = balance - money;
        return balance;
    }
}
