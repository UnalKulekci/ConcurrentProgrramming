package labs.f_synchronizedMethods;

public class Customer implements Runnable {

    private String name;
    private Account account;

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            int depositAmount = (int) (Math.random() * 1000);
            account.deposit(depositAmount);
            System.out.println(name + " has deposited " + depositAmount + ", balance: " + account.getBalance());

            int withdrawAmount = (int) (Math.random() * 1000);
            account.withdraw(withdrawAmount);
            System.out.println(name + " has withdrawn " + withdrawAmount + ", balance: " + account.getBalance());

            try {
                Thread.sleep(100); // Simulate some delay between operations
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

