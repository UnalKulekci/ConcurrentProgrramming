package Concurrency_HighLevel.R_BlockingQueue_PostOffice;

public class Package {
    private Customer sender;

    public Package(Customer sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Package{" +
                "sender=" + sender.getName() +
                '}';
    }
}
