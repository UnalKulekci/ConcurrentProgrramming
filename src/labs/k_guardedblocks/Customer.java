package labs.k_guardedblocks;

public class Customer implements Runnable {
    private String name;
    private PostOffice postOffice;

    public Customer(String name, PostOffice postOffice) {
        this.name = name;
        this.postOffice = postOffice;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Package pkg = new Package(this);
                postOffice.addPackage(pkg);
                System.out.println(name + " delivered: " + pkg);
                Thread.sleep((long) (Math.random() * 2000)); // Rastgele bekleme süresi
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

