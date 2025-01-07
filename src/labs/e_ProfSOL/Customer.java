package labs.e_ProfSOL;

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

            account.deposit((int)(Math.random() * 1000));
            System.out.println(name + ": has deposited money on account with new balance  => " + account.getBalance());

            account.withdraw((int)(Math.random() * 1000));
            System.out.println(name + ": has withdrawn money on account with new balance  => " + account.getBalance());

            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
