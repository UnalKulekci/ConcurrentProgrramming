package workShop.SOL_Normal;

/**
 * Represents a user who generates print jobs
 * Acts as a producer in the producer-consumer pattern
 */
public class User implements Runnable {
    // Instance variables for queue access and user identification
    private final PrintQueue printQueue;
    private final String userId;
    private static int jobCounter = 0;
    private final String userName;

    /**
     * Creates a User with specified print queue and ID
     * Assigns a real name based on user ID
     */
    public User(PrintQueue printQueue, String userId) {
        this.printQueue = printQueue;
        this.userId = userId;
        switch (userId) {
            case "User_1":
                this.userName = "Natasha";
                break;
            case "User_2":
                this.userName = "Alexi";
                break;
            case "User_3":
                this.userName = "Unal";
                break;
            default:
                this.userName = "Guest";
        }
    }

    /**
     * Continuously generates print jobs with random intervals
     * Each job has a unique ID and is added to the print queue
     */
    @Override
    public void run() {
        try {
            while (true) {
                int jobId = ++jobCounter;
                PrintJob job = new PrintJob(jobId, userName, "Document_" + jobId);
                System.out.println(userName + " is sending print job: Document_" + jobId);
                printQueue.addJob(job);
                Thread.sleep((long) (Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}