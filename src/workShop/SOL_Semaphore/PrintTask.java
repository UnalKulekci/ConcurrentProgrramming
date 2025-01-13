package workShop.SOL_Semaphore;

/**
 * Represents a print task in the mutex-based printing system
 */
public class PrintTask {
    private final int taskId;
    private final String userId;
    private final String document;

    public PrintTask(int taskId, String userId, String document) {
        this.taskId = taskId;
        this.userId = userId;
        this.document = document;
    }

    @Override
    public String toString() {
        return "PrintTask{" +
                "taskId=" + taskId +
                ", userId='" + userId + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
} 