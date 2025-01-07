package labs.e_ProfSOL;

public class Account {

    private int balance;
    public void withdraw(int amount) {
        balance -= amount;
    }
    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
