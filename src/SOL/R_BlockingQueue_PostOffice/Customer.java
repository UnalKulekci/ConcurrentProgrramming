package Concurrency_HighLevel.R_BlockingQueue_PostOffice;

import java.util.Random;

public class Customer implements Runnable {
    private String name;
    private PostOffice postOffice;

    public Customer(String name, PostOffice postOffice) {
        this.name = name;
        this.postOffice = postOffice;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            try {
                Thread.sleep(random.nextInt(1000));
                postOffice.register(new Package(this));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
