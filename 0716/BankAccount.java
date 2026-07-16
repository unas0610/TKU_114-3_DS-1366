public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = Math.max(initialBalance, 0);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount target, int amount) {
        if (target == null || target == this || amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        target.balance += amount;
        return true;
    }

    @Override
    public String toString() {
        return "帳戶：" + accountNumber + " | 戶名：" + owner + " | 餘額：" + balance + " 元";
    }
}