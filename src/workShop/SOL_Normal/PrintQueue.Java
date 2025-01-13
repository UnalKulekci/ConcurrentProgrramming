package workShop.SOL_Normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements a thread-safe bounded buffer for print jobs
 * Uses synchronized methods and wait/notify mechanism for thread synchronization
 */
class PrintQueue {
    // Queue to store print jobs and its maximum capacity
    private final Queue<PrintJob> queue;
    private final int capacity;

    /**
     * Creates a PrintQueue with specified capacity
     * @param capacity Maximum number of jobs that can be held in the queue
     */
    public PrintQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    /**
     * Adds a print job to the queue. If queue is full, the thread waits
     * @param job The print job to be added
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    public synchronized void addJob(PrintJob job) throws InterruptedException {
        while (queue.size() >= capacity) {
            System.out.println("Queue is full. User waiting: " + job.toString());
            wait();
        }
        queue.add(job);
        System.out.println("Job added to queue: " + job.toString());
        notifyAll();
    }

    /**
     * Retrieves and removes a print job from the queue. If queue is empty, the thread waits
     * @return The next print job in the queue
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    public synchronized PrintJob getJob() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Printer waiting...");
            wait();
        }
        PrintJob job = queue.poll();
        notifyAll();
        return job;
    }
}