package labs.k_guardedblocks;

public class Postman implements Runnable {

    private PostOffice postOffice;

    public Postman(PostOffice postOffice) {
        this.postOffice = postOffice;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Package pkg = postOffice.deliverPackage();
                System.out.println("Postman delivered: " + pkg);
                Thread.sleep((long) (Math.random() * 2000)); // Rastgele bekleme süresi
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

