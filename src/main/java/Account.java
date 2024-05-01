public class Account {

    private int balance;
    private int deposit;
    private int takeMoney;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getTakeMoney() {
        return takeMoney;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setTakeMoney(int takeMoney) {
        this.takeMoney = takeMoney;
    }
}
