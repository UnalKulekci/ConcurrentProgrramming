package workShop.SOL_Normal;

/**
 * Represents a printer that processes print jobs
 * Acts as a consumer in the producer-consumer pattern
 */

public class Printer implements Runnable {
    // Instance variables for queue access and printer identification
    private final PrintQueue printQueue;
    private final String printerId;

    /**
     * Creates a Printer with specified print queue and ID
     */
    public Printer(PrintQueue printQueue, String printerId) {
        this.printQueue = printQueue;
        this.printerId = printerId;
    }

    /**
     * Continuously processes print jobs from the queue
     */
    @Override
    public void run() {
        try {
            while (true) {
                PrintJob job = printQueue.getJob();
                System.out.println("Printer " + printerId + " is processing job: " + job.toString());
                Thread.sleep((long) (Math.random() * 3000));
                System.out.println("Printer " + printerId + " completed job: " + job.toString());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}