package workShop.SOL_Semaphore;

/**
 * Demonstrates the mutex-based print buffer system
 */
public class MutexDemo {
    public static void main(String[] args) {
        PrintBuffer printBuffer = new PrintBuffer(5);

        // Create and start client threads (producers)
        for (int i = 1; i <= 3; i++) {
            Thread clientThread = new Thread(new Client(printBuffer, "Client_" + i));
            clientThread.start();
        }

        // Create and start worker threads (consumers)
        for (int i = 1; i <= 2; i++) {
            Thread workerThread = new Thread(new PrintWorker(printBuffer, "Worker_" + i));
            workerThread.start();
        }
    }
} 