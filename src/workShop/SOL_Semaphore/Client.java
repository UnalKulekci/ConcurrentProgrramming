package workShop.SOL_Semaphore;

/**
 * Represents a client that generates print tasks (Producer)
 */
public class Client implements Runnable {
    private final PrintBuffer printBuffer;
    private final String clientId;
    private static int taskCounter = 0;
    private final String clientName;

    public Client(PrintBuffer printBuffer, String clientId) {
        this.printBuffer = printBuffer;
        this.clientId = clientId;
        switch (clientId) {
            case "Client_1":
                this.clientName = "Natasha";
                break;
            case "Client_2":
                this.clientName = "Alexi";
                break;
            case "Client_3":
                this.clientName = "Unal";
                break;
            default:
                this.clientName = "Guest";
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                int taskId = ++taskCounter;
                PrintTask task = new PrintTask(taskId, clientName, "Document_" + taskId);
                System.out.println(clientName + " is sending print task: Document_" + taskId);
                printBuffer.addTask(task);
                Thread.sleep((long) (Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 