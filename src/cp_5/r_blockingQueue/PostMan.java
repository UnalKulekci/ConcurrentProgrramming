package cp_5.r_blockingQueue;

import java.util.concurrent.BlockingQueue;

class PostMan implements Runnable {
    private BlockingQueue<Package> postOffice;
    private String name;

    public PostMan(String name, BlockingQueue<Package> postOffice) {
        this.name = name;
        this.postOffice = postOffice;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Package pkg = postOffice.take(); // Paket yoksa bloklanır
                System.out.println(name + " delivering: " + pkg);
                Thread.sleep(1000); // Teslimat süresi
                System.out.println(name + " delivered: " + pkg);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
