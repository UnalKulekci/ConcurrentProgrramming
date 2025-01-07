package Concurrency_HighLevel.R_BlockingQueue_PostOffice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PostOffice {

    private BlockingQueue<Package> queue = new LinkedBlockingQueue<>();

    public void register(Package aPackage) {
        try {
            queue.put(aPackage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeForDelivery() {
        try {
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
