package cp_5.r_blockingQueue;

import java.util.concurrent.BlockingQueue;

class Customer implements Runnable {

    private String name;
    private BlockingQueue<Package> postOffice;
    public Customer(String name, BlockingQueue<Package> postOffice) {
        this.name = name;
        this.postOffice = postOffice;
    }

    @Override
    public void run() {
        try {
            // Her müşteri 3 paket göndersin
            for (int i = 0; i < 3; i++) {
                Package pkg = new Package(name);
                postOffice.put(pkg);
                System.out.println(name + " registered: " + pkg);
                Thread.sleep(500); // Paketler arası bekleme
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
