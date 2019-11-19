package concurrent.lesson1;

/**
 * 演示：最正常情况下的账户的余额情况
 * 账户
 */
public class NormalAccount {

    /**
     * 余额
     */
    private Double balance;

    /**
     * 转入
     * @param money
     * @return
     */
    public Double transferIn(Double money) {
        this.balance = balance + money;
        return balance;
    }

    /**
     * 转出
     * @param money
     * @return
     */
    public Double transferOut(Double money) {
        this.balance = balance - money;
        return balance;
    }
}
