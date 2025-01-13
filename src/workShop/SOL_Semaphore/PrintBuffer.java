package workShop.SOL_Semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Implements a thread-safe bounded buffer using binary semaphores (mutex)
 */
public class PrintBuffer {
    private final Queue<PrintTask> buffer;
    private final int capacity;
    private final Semaphore mutex;
    private final Semaphore empty;
    private final Semaphore full;

    public PrintBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
        this.mutex = new Semaphore(1);    // Binary semaphore for mutual exclusion
        this.empty = new Semaphore(capacity); // Counting semaphore for empty slots
        this.full = new Semaphore(0);     // Counting semaphore for full slots
    }

    public void addTask(PrintTask task) throws InterruptedException {
        empty.acquire();  // Wait if buffer is full
        mutex.acquire();  // Enter critical section
        
        try {
            buffer.add(task);
            System.out.println("Task added to buffer: " + task.toString());
        } finally {
            mutex.release(); // Exit critical section
        }
        full.release();   // Signal that a new item is available
    }

    public PrintTask getTask() throws InterruptedException {
        full.acquire();   // Wait if buffer is empty
        mutex.acquire();  // Enter critical section
        
        PrintTask task = null;
        try {
            task = buffer.poll();
            System.out.println("Task retrieved from buffer: " + task.toString());
        } finally {
            mutex.release(); // Exit critical section
        }
        empty.release();  // Signal that a slot is available
        return task;
    }
} 