package workShop.SOL_Normal;

/**
 * Represents a print job in the printing system
 * Contains information about the job, user and document
 */
public class PrintJob {
    // Job identification and details
    private final int jobId;
    private final String userId;
    private final String document;

    /**
     * Creates a print job with specified details
     * @param jobId Unique identifier for the job
     * @param userId ID of the user who created the job
     * @param document Name or description of the document
     */
    public PrintJob(int jobId, String userId, String document) {
        this.jobId = jobId;
        this.userId = userId;
        this.document = document;
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "jobId=" + jobId +
                ", userId='" + userId + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
