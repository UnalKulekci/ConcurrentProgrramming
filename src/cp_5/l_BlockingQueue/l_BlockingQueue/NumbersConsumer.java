package cp_5.l_BlockingQueue.l_BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public NumbersConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                System.out.println(Thread.currentThread().getName()
                        + " takes: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
