package labs.f_synchronizedMethods;

public class Account {

    private int balance;

    // Synchronized method for withdraw
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", new balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw: " + amount + " but insufficient balance.");
        }
    }

    // Synchronized method for deposit
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", new balance: " + balance);
    }

    public synchronized int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}

