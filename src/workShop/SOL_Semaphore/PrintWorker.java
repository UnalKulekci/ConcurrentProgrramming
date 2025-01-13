package workShop.SOL_Semaphore;

/**
 * Represents a print worker that processes print tasks (Consumer)
 */
public class PrintWorker implements Runnable {
    private final PrintBuffer printBuffer;
    private final String workerId;

    public PrintWorker(PrintBuffer printBuffer, String workerId) {
        this.printBuffer = printBuffer;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                PrintTask task = printBuffer.getTask();
                System.out.println("Worker " + workerId + " is processing task: " + task.toString());
                Thread.sleep((long) (Math.random() * 3000));
                System.out.println("Worker " + workerId + " completed task: " + task.toString());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 