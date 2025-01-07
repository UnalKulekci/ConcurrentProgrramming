package Concurrency_HighLevel.R_BlockingQueue_PostOffice;

public class Postman implements Runnable {
    private PostOffice postOffice;

    public Postman(PostOffice postOffice) {
        this.postOffice = postOffice;
    }

    @Override
    public void run() {
        while (true) {
            postOffice.takeForDelivery();
        }
    }
}
