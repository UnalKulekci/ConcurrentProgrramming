package cp_5.r_blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PostOfficeSimulation {
    public static void main(String[] args) {

        // Creating unbounded queues
        BlockingQueue<Package> postOffice = new LinkedBlockingQueue<>(10);

        // Müşteriler
        Thread[] customers = {
                new Thread(new Customer("Alice", postOffice)),
                new Thread(new Customer("Bob", postOffice)),
                new Thread(new Customer("Charlie", postOffice))
        };

        // Postacılar
        Thread[] postmen = {
                new Thread(new PostMan("PostMan-1", postOffice)),
                new Thread(new PostMan("PostMan-2", postOffice))
        };

        // Postacıları başlat
        for (Thread postman : postmen) {
            postman.start();
        }

        // Müşterileri başlat
        for (Thread customer : customers) {
            customer.start();
        }
    }
}
