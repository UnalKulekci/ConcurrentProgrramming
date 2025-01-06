package cp5_ProfCodes.slides_exmp.BlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestingBlockingQueue {
    public static void main(String[] args) {

        int BOUND = 10; // maximum number of elements in the queue
        int N_PRODUCERS = 3; // number of producers
        int N_CONSUMER = Runtime.getRuntime().availableProcessors(); // number of consumers

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(BOUND);


        for (int i = 0; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue)).start();
        }

        for (int i = 0; i < N_CONSUMER; i++) {
            new Thread(new NumbersConsumer(queue)).start();
        }
    }

}

// Rastgele sayılar üretir ve kuyruğa ekler.
class NumbersProducer implements Runnable {
    private BlockingQueue<Integer> queue;

    // Constructor
    public NumbersProducer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    // Runnable interface'i implement ettigimiz icin run method'unu override etmemiz gerekiyor
    public void run() {
        try {
            Random random = new Random();
            while (true) {
                queue.put(random.nextInt(100)); // Rastgele sayı ekleme
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Kuyruktan sayıları alır ve ekrana yazdırır.
class NumbersConsumer implements Runnable {

    private BlockingQueue<Integer> queue;
    public NumbersConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                Integer number = queue.take(); // Kuyruktan sayı alma
                System.out.println(Thread.currentThread().getName() + " takes: " + number); // Alınan sayıyı yazdırma
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

