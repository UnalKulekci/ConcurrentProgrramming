package labs.f_synchronizedMethods;


public class TestingThreadInterferences2 {

    public static void main(String[] args) {

        // shared account object
        Account account = new Account();

        // Create customers
        Thread customer1 = new Thread(new Customer("Damien", account), "Customer-Damien");
        Thread customer2 = new Thread(new Customer("Hélène", account), "Customer-Hélène");

        // Start threads
        customer1.start();
        customer2.start();
    }
}
